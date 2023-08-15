package bp.com.auth.mappers;

import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.models.entity.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class User2UserEntityMapper {

    public UserEntity toUserEntity(User user) {
        if (user == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(user.password());
        userEntity.setDeleted(user.isDeleted());
        userEntity.setPermissions(user.permissions());
        userEntity.setPhone(user.phone());
        userEntity.setEmail(user.email());
        userEntity.setFirstName(user.firstName());
        userEntity.setLastName(user.lastName());
        userEntity.setRole(UserRole.valueOf(user.role()));

        return userEntity;
    }

    public List<UserEntity> toUserEntityList(List<User> users) {
        List<UserEntity> userEntities = new ArrayList<>();
        if (users != null)
            users.forEach(user -> userEntities.add(toUserEntity(user)));
        return userEntities;
    }

}
