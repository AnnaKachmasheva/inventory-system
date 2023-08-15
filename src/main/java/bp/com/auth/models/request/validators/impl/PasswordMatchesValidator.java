package bp.com.auth.models.request.validators.impl;

import bp.com.auth.models.request.RegistrationRequest;
import bp.com.auth.models.request.validators.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object obj, ConstraintValidatorContext context) {
        RegistrationRequest registrationRequest = (RegistrationRequest) obj;
        return registrationRequest.password().equals(registrationRequest.matchingPassword());
    }

}