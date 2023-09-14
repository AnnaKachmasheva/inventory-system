package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.models.domain.User;
import bp.com.auth.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCurrentUserUseCase {

    private final UserRepositoryAdapter adapter;

    public User execute(CustomUserDetails currentUser) {
        return adapter.findByEmail(currentUser.getEmail());
    }

}
