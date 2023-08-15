package bp.com.auth.adapters;

import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.LoginRequest;

import java.util.List;

public interface UserRepositoryAdapter {

    User login(LoginRequest loginRequest);

    User create(User user);

    void delete(User user);

    List<User> findAll();

    User findById(Long id);

    User update(User user);

    void resetPassword(String password);

}