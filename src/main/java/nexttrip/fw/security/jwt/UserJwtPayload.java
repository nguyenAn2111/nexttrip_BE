package nexttrip.fw.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(
        value = {"password", "enabled", "authorities", "accountNonExpired", "accountNonLocked" }
)

public class UserJwtPayload implements Serializable, UserDetails {
    private Integer id;
    private String username;
    private String password;
    private String fullName;


    public UserJwtPayload(Map<String, Object> payload) {
        id = Integer.parseInt((String) payload.get("id"));
        username = (String) payload.get("username");
        fullName = (String) payload.get("fullName");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return null; }

    @Override
    public String getUsername() {return username;}

    @Override
    public String getPassword() {return password;}

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}
}
