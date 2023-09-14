package bp.com.auth.exeptions;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException(Long id) {
        super(String.format("User with Id %d not found", id));
    }

    public NoUserFoundException(String email) {
        super(String.format("User with email %s not found", email));
    }

}
