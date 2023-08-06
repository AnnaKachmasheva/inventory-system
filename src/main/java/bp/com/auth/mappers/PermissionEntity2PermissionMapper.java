package bp.com.auth.mappers;

import bp.com.auth.domain.Permission;
import bp.com.auth.entity.PermissionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionEntity2PermissionMapper {

    public Permission toPermission(PermissionEntity permissionEntity) {
        return permissionEntity == null ? null : Permission.builder()
                .id(permissionEntity.getId())
                .name(permissionEntity.getName())
                .build();
    }

    public List<Permission> toPermissionSet(List<PermissionEntity> permissionEntities) {
        List<Permission> permissions = new ArrayList<>();
        if (permissionEntities != null)
            permissionEntities.forEach(permissionEntity -> permissions.add(toPermission(permissionEntity)));
        return permissions;
    }
}
