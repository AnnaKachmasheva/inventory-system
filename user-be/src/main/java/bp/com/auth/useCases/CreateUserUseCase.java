package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.enums.UserRole;
import bp.com.auth.models.request.SignUpRequest;
import bp.com.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepositoryAdapter adapter;
    private final PasswordEncoder passwordEncoder;

    public User execute(User user) {
        return adapter.create(user);
    }

    public User execute(SignUpRequest signUpRequest) {
        String encodePassword = passwordEncoder.encode(signUpRequest.password());

        var user = User.builder()
                .firstName(signUpRequest.firstName())
                .lastName(signUpRequest.lastName())
                .email(signUpRequest.email())
                .password(encodePassword)
                .role(UserRole.ROLE_USER.name())
                .build();

        return adapter.create(user);
    }
}
