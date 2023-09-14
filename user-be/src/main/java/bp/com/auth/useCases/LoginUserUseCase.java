package bp.com.auth.useCases;

import bp.com.auth.models.entity.enums.TokenType;
import bp.com.auth.models.request.SignInRequest;
import bp.com.auth.models.response.JwtAuthenticationResponse;
import bp.com.auth.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationResponse execute(SignInRequest request) {
        String email = request.email();
        String password = request.password();

        var us = new UsernamePasswordAuthenticationToken(email, password);

        Authentication authentication = authenticationManager
                .authenticate(us);

        return new JwtAuthenticationResponse(tokenProvider.generate(authentication), TokenType.BEARER);
    }

}
