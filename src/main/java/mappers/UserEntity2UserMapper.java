package mappers;

import bp.com.auth.domain.Permission;
import bp.com.auth.domain.User;
import bp.com.auth.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserEntity2UserMapper {

    private final PermissionEntity2PermissionMapper permissionEntity2PermissionMapper;

    public User toUser(UserEntity userEntity) {
        if (userEntity == null) return null;
        List<Permission> permissions = permissionEntity2PermissionMapper.toPermissionSet(userEntity.getPermissions());
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .role(userEntity.getRole().name())
                .password(userEntity.getPassword())
                .isDeleted(userEntity.isDeleted())
                .permissions(permissions)
                .build();
    }

    public List<User> toUserList(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        if (userEntities != null)
            userEntities.forEach(userEntity -> users.add(toUser(userEntity)));
        return users;
    }

}
