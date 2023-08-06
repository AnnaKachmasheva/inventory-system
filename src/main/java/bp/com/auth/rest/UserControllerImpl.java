package bp.com.auth.rest;

import bp.com.auth.domain.User;
import bp.com.auth.facades.UserFacade;
import bp.com.auth.rest.interfaces.UserController;
import bp.com.auth.rest.request.LoginRequest;
import bp.com.auth.rest.request.RegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserControllerImpl implements UserController {

    private final UserFacade userFacade;


    @Override
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(userFacade.login(loginRequest));
    }

    @Override
    public ResponseEntity<?> registration(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok().body(userFacade.registration(registrationRequest));
    }

    @Override
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(userFacade.create(user));
    }

    @Override
    public ResponseEntity<?> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<?> resetPassword(String email) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(User user) {
        return null;
    }

    //done

    @Override
    @GetMapping(value = "/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userFacade.findById(id));
    }

    @Override
    @GetMapping(value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(userFacade.findAll());
    }

}