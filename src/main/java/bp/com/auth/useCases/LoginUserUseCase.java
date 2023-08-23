package bp.com.auth.useCases;

import bp.com.auth.config.JwtTokenProvider;
import bp.com.auth.models.entity.enums.TokenType;
import bp.com.auth.models.request.LoginRequest;
import bp.com.auth.models.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {

    private final AuthenticationProvider authenticationProvider;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;


    public JwtAuthenticationResponse execute(LoginRequest request) {
        String email = request.email();
        String password = request.password();

        Authentication auth = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationProvider.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JwtAuthenticationResponse(jwtTokenProvider.createToken(authentication), TokenType.BEARER);
    }

}
