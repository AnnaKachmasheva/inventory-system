package bp.com.auth.useCases;

import adapters.UserRepositoryAdapter;
import bp.com.auth.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {

    private final UserRepositoryAdapter adapter;

    public void execute(User user) {
        adapter.delete(user);
    }


}
