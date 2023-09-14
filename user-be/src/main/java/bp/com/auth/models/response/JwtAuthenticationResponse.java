package bp.com.auth.models.response;

import bp.com.auth.models.entity.enums.TokenType;

public record JwtAuthenticationResponse(
        String token,
        TokenType tokenType) {
}