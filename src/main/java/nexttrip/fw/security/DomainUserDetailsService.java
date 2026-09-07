package nexttrip.fw.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.entity.User;
import nexttrip.app.repository.UserRepository;
import nexttrip.fw.security.jwt.UserJwtPayload;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Service

public class DomainUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername (String username) {
        String usernameLowerCase     = username.toLowerCase(Locale.ENGLISH);
        User user = this.userRepository.findByUsername(usernameLowerCase).orElseThrow(() -> new UsernameNotFoundException("User" + usernameLowerCase + "was not found in the database"));
        return mapToJwtPayload(user);
    }

    @Transactional
    public UserJwtPayload mapToJwtPayload (User user) {
        return new UserJwtPayload(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName()
        );
    }
}
