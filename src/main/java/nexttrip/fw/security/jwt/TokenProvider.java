package nexttrip.fw.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nexttrip.app.common.Constants;
import nexttrip.fw.security.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Component
@Log4j2
@RequiredArgsConstructor
public class TokenProvider {

    @Value("#{new Long('${jwt.token-validity-in-milliseconds}')}")
    private Long tokenValidityInMilliseconds;
    @Value("#{new Long('${jwt.refresh-token-validity-in-milliseconds}')}")
    private Long refreshTokenValidityInMilliseconds;
    @Value("${jwt.base64-secret}")
    private String jwtSecret;

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String PAYLOAD_KEY = "payload";
    private static final String INVALID_JWT_TOKEN = "Invalid JWT Token";

    private final DomainUserDetailsService domainUserDetailsService;
    private final RedisTemplate<String, String> redisTemplate;
    private Key key;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        key = Keys.hmacShaKeyFor(keyBytes);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(Authentication authentication) {
        long now = System.currentTimeMillis();
        Date validity = new Date(now + tokenValidityInMilliseconds);
        UserJwtPayload userJwtPayload = (UserJwtPayload) authentication.getPrincipal();

        String jti = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(Constants.Redis.TOKEN_KEY + authentication.getName(), jti, tokenValidityInMilliseconds, TimeUnit.MILLISECONDS);

        return Jwts
                .builder()
                .setId(jti)
                .setSubject(authentication.getName())
                .setExpiration(validity)
                .claim(PAYLOAD_KEY, userJwtPayload)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String createRefreshToken(Authentication authentication) {
        long now = System.currentTimeMillis();
        Date validity = new Date(now + refreshTokenValidityInMilliseconds);

        String jti = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(Constants.Redis.REFRESH_TOKEN_KEY + authentication.getName(), jti, refreshTokenValidityInMilliseconds, TimeUnit.MILLISECONDS);

        return Jwts
                .builder()
                .setId(jti)
                .setSubject(authentication.getName())
                .setExpiration(validity)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            String subject = claims.getSubject();
            String jti = claims.getId();
            if (StringUtils.hasText(redisTemplate.opsForValue().get(Constants.Redis.TOKEN_KEY + subject))){
                return jti.equals(redisTemplate.opsForValue().get(Constants.Redis.REFRESH_TOKEN_KEY + subject));
            }
            return false;
        } catch (ExpiredJwtException | IllegalArgumentException | UnsupportedJwtException | MalformedJwtException e) {
            log.trace(INVALID_JWT_TOKEN, e);
            return false;
        }
    }

    public Authentication getAuthentication(String token) throws AuthenticationException {
        if(token == null){ return null;}
        Claims claims = jwtParser.parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
        UserJwtPayload userJwtPayload = new UserJwtPayload((Map <String, Object>) claims.get("payload"));
        return new UsernamePasswordAuthenticationToken(userJwtPayload, token, null);
    }

}
