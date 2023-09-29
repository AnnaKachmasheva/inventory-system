package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.models.domain.PageUsers;
import bp.com.auth.models.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUsersUseCase {


    private final UserRepositoryAdapter adapter;

    public PageUsers execute(int page, int size) {
        return adapter.findAll(page, size);
    }

}
