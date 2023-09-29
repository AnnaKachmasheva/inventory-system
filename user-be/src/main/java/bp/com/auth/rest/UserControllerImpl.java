package bp.com.auth.rest;

import bp.com.auth.facades.UserFacade;
import bp.com.auth.models.domain.User;
import bp.com.auth.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(userFacade.findAll(page, size));
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