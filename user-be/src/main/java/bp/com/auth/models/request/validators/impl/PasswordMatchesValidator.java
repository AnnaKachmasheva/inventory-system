package bp.com.auth.models.request.validators.impl;

import bp.com.auth.models.request.SignUpRequest;
import bp.com.auth.models.request.validators.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object obj, ConstraintValidatorContext context) {
        SignUpRequest signUpRequest = (SignUpRequest) obj;
        return signUpRequest.password().equals(signUpRequest.matchingPassword());
    }

}