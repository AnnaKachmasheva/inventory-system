package bp.com.auth.useCases;

import adapters.UserRepositoryAdapter;
import bp.com.auth.domain.User;
import bp.com.auth.entity.enums.UserRole;
import bp.com.auth.rest.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepositoryAdapter adapter;

    public User execute(User user) {
        return adapter.create(user);
    }

    public User execute(RegistrationRequest registrationRequest) {
        User user = User.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(registrationRequest.getPassword())
                .role(UserRole.ROLE_USER.name())
                .build();

        return adapter.create(user);
    }
}
