package bp.com.auth.models.request;

public record PasswordRequest(String oldPassword,
                              String newPassword,
                              String token) {
}
