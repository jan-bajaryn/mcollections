package by.itransition.mcollections.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@Data
public class JwtResponse {
    private final String token;
    private final Collection<? extends GrantedAuthority> authorities;
}
