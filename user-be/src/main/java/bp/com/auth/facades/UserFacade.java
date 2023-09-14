package bp.com.auth.facades;

import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.SignInRequest;
import bp.com.auth.models.request.SignUpRequest;
import bp.com.auth.models.response.JwtAuthenticationResponse;
import bp.com.auth.security.CustomUserDetails;
import bp.com.auth.useCases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final LoginUserUseCase loginUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final GetCurrentUserUseCase getCurrentUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

    public User signup(SignUpRequest signUpRequest) {
        return createUserUseCase.execute(signUpRequest);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest) {
        return loginUserUseCase.execute(signInRequest);
    }

    public User current(CustomUserDetails currentUser) {
        return getCurrentUserUseCase.execute(currentUser);
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