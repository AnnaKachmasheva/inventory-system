package bp.com.auth.rest;

import bp.com.auth.facades.UserFacade;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.LoginRequest;
import bp.com.auth.models.request.RegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserControllerImpl implements UserController {

    private final UserFacade userFacade;

    @Override
    @PostMapping(
            value = "/registration",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registration(@Valid @RequestBody RegistrationRequest registrationRequest) {
        User savedUser = userFacade.registration(registrationRequest);
        return ResponseEntity.ok().body(savedUser);
    }

    @Override
    @PostMapping(
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(userFacade.login(loginRequest));
    }

    @Override
    @GetMapping(
            value = "/current",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(authentication.getPrincipal());
    }


    @Override
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        User savedUser = userFacade.create(user);
        return ResponseEntity.created(URI.create("/" + savedUser.id().toString())).body(savedUser);
    }

    @Override
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @Valid @RequestBody User user) {
        User upatedUser = userFacade.update(user);
        return ResponseEntity.ok().body(upatedUser);
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
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userFacade.findById(id));
    }

    @Override
    @GetMapping(value = "/users")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(userFacade.findAll());
    }

}