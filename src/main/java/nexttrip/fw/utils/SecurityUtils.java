package nexttrip.fw.utils;

import lombok.extern.slf4j.Slf4j;

import nexttrip.fw.security.jwt.UserJwtPayload;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class SecurityUtils {

    public static String getCurrentUsernameLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserJwtPayload userJwtPayload = extractPrincipal(securityContext.getAuthentication());
        return userJwtPayload != null ? userJwtPayload.getUsername() : null;
    }

    public static Integer getCurrentUserIdLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserJwtPayload userJwtPayload = extractPrincipal(securityContext.getAuthentication());
        return userJwtPayload != null ? userJwtPayload.getId() : null;
    }

    private static UserJwtPayload extractPrincipal(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof UserJwtPayload) {
            return (UserJwtPayload) authentication.getPrincipal();
        }
        return null;
    }
}
