package bp.com.auth.exeptions;

public class PasswordNotMatchesException extends RuntimeException {

    public PasswordNotMatchesException(String email) {
        super(String.format("User with Email:{ %s } have another password}", email));
    }
}
