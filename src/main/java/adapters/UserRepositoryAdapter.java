package adapters;

import bp.com.auth.domain.User;
import bp.com.auth.rest.request.LoginRequest;

import java.util.List;

public interface UserRepositoryAdapter {

    String login(LoginRequest loginRequest);

    User create(User user);

    void delete(User user);

    List<User> findAll();

    User findById(Long id);

    User update(User user);

    void resetPassword(String password);
}