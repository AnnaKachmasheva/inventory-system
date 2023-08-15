package bp.com.auth.models.request;

import bp.com.auth.models.request.validators.PasswordMatches;
import bp.com.auth.models.request.validators.ValidEmail;
import jakarta.validation.constraints.NotNull;

@PasswordMatches
public record RegistrationRequest(@NotNull String firstName,
                                  @NotNull String lastName,
                                  @NotNull @ValidEmail String email,
                                  @NotNull String password,
                                  @NotNull String matchingPassword) {
}
