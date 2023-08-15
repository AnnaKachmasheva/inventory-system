package bp.com.auth.mappers;

import bp.com.auth.models.entity.enums.Permission;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserEntity2UserMapper {

    public User toUser(UserEntity userEntity) {
        if (userEntity == null) return null;
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .role(userEntity.getRole().name())
                .password(userEntity.getPassword())
                .isDeleted(userEntity.isDeleted())
                .permissions(userEntity.getPermissions())
                .build();
    }

    public List<User> toUserList(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        if (userEntities != null)
            userEntities.forEach(userEntity -> users.add(toUser(userEntity)));
        return users;
    }

}
