package bp.com.auth.useCases;

import bp.com.auth.models.domain.User;
import bp.com.auth.security.UserDetailsImpl;
import bp.com.auth.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCurrentUserUseCase {

    public User execute() {
        return null;
    }

}
