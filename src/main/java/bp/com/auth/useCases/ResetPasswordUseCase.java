package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResetPasswordUseCase {

    private final UserRepositoryAdapter adapter;

    public void execute(String password) {
        adapter.resetPassword(password);
    }

}
