package exeptions;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException(Long id) {
        super(String.format("User with Id %d not found", id));
    }
}
