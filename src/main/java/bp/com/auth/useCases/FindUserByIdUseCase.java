package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByIdUseCase {

    private final UserRepositoryAdapter adapter;

    public User execute(Long id) {
        return adapter.findById(id);
    }

}
