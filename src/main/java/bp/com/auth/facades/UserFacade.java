package bp.com.auth.facades;

import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.LoginRequest;
import bp.com.auth.models.request.RegistrationRequest;
import bp.com.auth.models.response.JwtAuthenticationResponse;
import bp.com.auth.useCases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final LoginUserUseCase loginUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

    public User registration(RegistrationRequest registrationRequest) {
        return createUserUseCase.execute(registrationRequest);
    }

    public JwtAuthenticationResponse login(LoginRequest loginRequest) {
        return loginUserUseCase.execute(loginRequest);
    }



    public User create(User user) {
        return createUserUseCase.execute(user);
    }

    public User update(User user) {
        return updateUserUseCase.execute(user);
    }

    public void delete(User user) {
        deleteUserUseCase.execute(user);
    }

    public List<User> findAll() {
        return findAllUsersUseCase.execute();
    }

    public User findById(Long id) {
        return findUserByIdUseCase.execute(id);
    }


}