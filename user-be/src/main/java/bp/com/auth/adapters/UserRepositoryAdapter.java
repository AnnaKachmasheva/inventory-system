package bp.com.auth.adapters;

import bp.com.auth.models.domain.PageUsers;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.SignInRequest;

import java.util.List;

public interface UserRepositoryAdapter {

    User login(SignInRequest signInRequest);

    User create(User user);

    void delete(User user);

    PageUsers findAll(int page, int size);

    User findById(Long id);

    User update(User user);

    void resetPassword(String password);

    User findByEmail(String email);
}