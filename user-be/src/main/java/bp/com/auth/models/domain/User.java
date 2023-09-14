package bp.com.auth.models.domain;

import bp.com.auth.models.entity.enums.Permission;
import lombok.Builder;

import java.util.List;

@Builder
public record User(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String phone,
                   String role,
                   String password,
                   boolean isDeleted,
                   List<Permission> permissions) {
}