package bp.com.auth.rest.interfaces;

import bp.com.auth.domain.User;
import bp.com.auth.rest.request.LoginRequest;
import bp.com.auth.rest.request.RegistrationRequest;
import org.springframework.http.ResponseEntity;

public interface UserController {

    /**
     * POST user/api/login
     *
     * @param loginRequest
     * @return
     */
    public ResponseEntity<?> authenticate(LoginRequest loginRequest);


    /**
     * POST user/api/registartion
     *
     * @param registrationRequest
     * @return
     */
    public ResponseEntity<?> registration(RegistrationRequest registrationRequest);

    /**
     * POST user/api/users
     *
     * @param user
     * @return
     */
    public ResponseEntity<?> create(User user);

    /**
     * PUT user/api/user
     *
     * @param user
     * @return
     */
    public ResponseEntity<?> update(User user);

    /**
     * POST user/api/reset-password
     *
     * @param email
     * @return
     */
    public ResponseEntity<?> resetPassword(String email);

    /**
     * DELETE user/api/user
     *
     * @param user
     * @return
     */
    public ResponseEntity<?> delete(User user);

    /**
     * GET user/api/user
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> findById(Long id);

    /**
     * GET user/api/users
     *
     * @return
     */
    public ResponseEntity<?> findAll();

}