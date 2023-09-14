package bp.com.auth.rest;

import bp.com.auth.facades.UserFacade;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.request.SignInRequest;
import bp.com.auth.models.request.SignUpRequest;
import bp.com.auth.security.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserControllerImpl {

    private final UserFacade userFacade;

    @GetMapping(
            value = "/me",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        User user = userFacade.current(currentUser);
        log.info("Get current user: {}", user);
        return ResponseEntity.ok(user);
    }

    // todo
    
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    @PostMapping
//    public ResponseEntity<?> create(@Valid @RequestBody User user) {
//        User savedUser = userFacade.create(user);
//        log.info("Create user: {}", savedUser);
//        return ResponseEntity.created(URI.create("/" + savedUser.id().toString())).body(savedUser);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        User user = userFacade.findById(id);
//        log.info("Get user:{} by id: {}", user, id);
//        return ResponseEntity.ok().body(user);
//    }


//    @GetMapping
//    public ResponseEntity<?> findAll() {
//        return ResponseEntity.ok().body(userFacade.findAll());
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id,
//                                    @Valid @RequestBody User user) {
//        User upatedUser = userFacade.update(user);
//        return ResponseEntity.ok().body(upatedUser);
//    }
//
//    public ResponseEntity<?> resetPassword(String email) {
//        return null;
//    }
//
//    public ResponseEntity<?> delete(User user) {
//        return null;
//    }
}