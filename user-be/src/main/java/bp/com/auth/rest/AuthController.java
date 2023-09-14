package bp.com.auth.rest;

import bp.com.auth.facades.UserFacade;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.SignInRequest;
import bp.com.auth.models.request.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserFacade userFacade;

    @PostMapping(
            value = "/signup",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest signUpRequest) {
        User savedUser = userFacade.signup(signUpRequest);
        log.info("Created user: {}", savedUser);
        return ResponseEntity.ok().body(savedUser);
    }

    @PostMapping(
            value = "/signin",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signin(@Valid @RequestBody SignInRequest signInRequest) {
        var response = userFacade.signin(signInRequest);
        log.info("LogIn user: {}", signInRequest);
        return ResponseEntity.ok().body(response);
    }

}
