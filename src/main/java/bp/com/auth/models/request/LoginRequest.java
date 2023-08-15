package bp.com.auth.models.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank(message = "Email is requiring") String email,
                           @NotBlank(message = "Password is requiring") String password) {
}