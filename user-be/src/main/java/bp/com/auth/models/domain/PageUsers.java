package bp.com.auth.models.domain;

import lombok.Builder;

import java.util.List;


@Builder
public record PageUsers(
        List<User> content,
        boolean isEmpty,
        int totalPages,
        long totalElements) {
}
