package bp.com.auth.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    ErrorResponse handlerUserAlreadyExistsException(UserAlreadyExistException e) {
        return ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("Create user")
                .type(URI.create("https://api.auth/errors/exists"))
                .property("errorCategory", "Generic")
                .property("timestamp", Instant.now())
                .build();
    }

    @ExceptionHandler(NoUserFoundException.class)
    ErrorResponse handlerNoUserFoundException(NoUserFoundException e) {
        return ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage())
                .title("Get user")
                .type(URI.create("https://api.auth/errors/notfound"))
                .property("errorCategory", "Generic")
                .property("timestamp", Instant.now())
                .build();
    }

    @ExceptionHandler(PasswordNotMatchesException.class)
    ErrorResponse handlerPasswordNotMatchesException(PasswordNotMatchesException e) {
        return ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("Passwords not matches")
                .type(URI.create("https://api.auth/errors/password"))
                .property("errorCategory", "Generic")
                .property("timestamp", Instant.now())
                .build();
    }


}