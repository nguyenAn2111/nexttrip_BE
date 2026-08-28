package nexttrip.fw.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import nexttrip.fw.security.jwt.TokenProvider;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtOncePerRequestFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;

    public JwtOncePerRequestFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilterInternal(
            @NotNull
            HttpServletRequest servletRequest,
            @NotNull
            HttpServletResponse servletResponse,
            @NotNull
            FilterChain filterChain) throws IOException {

        String jwt = null;
        try {
            jwt = resolveToken(servletRequest);
            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
                Authentication authentication = tokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e) {
            log.error(
                    "Request uri: {} happen UnauthorizedException with token: {} message {},", servletRequest, jwt, e.getMessage());
            BaseResponse<?> baseResponse = BaseResponse.error(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
            servletResponse.setStatus(HttpStatus.OK.value());
            servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            servletResponse.getWriter().write(convertObjectToJson(baseResponse));
        }
    }
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) { return null; }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
