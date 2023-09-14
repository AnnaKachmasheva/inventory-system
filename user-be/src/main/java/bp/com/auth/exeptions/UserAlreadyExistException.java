package bp.com.auth.exeptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String email) {
        super(String.format("User with Email:{ %s } already exist", email));
    }

}
