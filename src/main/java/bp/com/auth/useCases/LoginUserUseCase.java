package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.rest.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {

    private final UserRepositoryAdapter adapter;

    public String execute(LoginRequest loginRequest) {
        return adapter.login(loginRequest);
    }


}
