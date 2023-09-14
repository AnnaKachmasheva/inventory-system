package bp.com.auth.exeptions;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException() {
        super("Provided credentials don't match.");
    }

}