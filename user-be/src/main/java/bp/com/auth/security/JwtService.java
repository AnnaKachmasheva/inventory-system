package bp.com.auth.security;

import bp.com.auth.models.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUserName(String token);

    String generateToken(User user);

    boolean isTokenValid(String token, UserDetailsImpl userDetails);

}
