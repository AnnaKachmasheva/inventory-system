package bp.com.auth;

import bp.com.auth.models.entity.enums.Permission;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.models.entity.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private final Random random = new Random();

    public List<Permission> getPermissionList(int minCount, int maxCount) {
        long count = random.nextLong(minCount, maxCount);

        List<Permission> permissionEntities = new ArrayList<>();
        while (count >= 0) {
            permissionEntities.add(getPermission());
            count--;
        }

        return permissionEntities;
    }

    private Permission getPermission() {
        int count = Permission.values().length;
        int randomIndex = random.nextInt(0, count - 1);
        return Permission.values()[randomIndex];
    }

    public UserEntity getUserEntity() {
        List<Permission> permissionEntities = getPermissionList(0, 10);
        long id = random.nextLong(0, 1000);
        String firstName = "ADAM_" + random.nextInt();
        String lastName = "SMITH_" + random.nextInt();
        String phone = "123456_" + random.nextInt();
        String email = random.nextInt() + "_@mail.com";
        String password = "PASSWORD_" + random.nextInt();
        UserRole role = UserRole.ROLE_USER;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setPhone(phone);
        userEntity.setDeleted(random.nextBoolean());
        userEntity.setRole(role);
        userEntity.setPassword(password);
        userEntity.setPermissions(permissionEntities);

        return userEntity;
    }

    public List<UserEntity> getUserEntityList(int minCount, int maxCount) {
        long count = random.nextLong(minCount, maxCount);

        List<UserEntity> userEntityList = new ArrayList<>();
        while (count >= 0) {
            userEntityList.add(getUserEntity());
            count--;
        }

        return userEntityList;
    }

    public User getUser() {
        List<Permission> permissions = getPermissionList(0, 10);
        long id = random.nextLong(0, 1000);
        String firstName = "ADAM_" + random.nextInt();
        String lastName = "SMITH_" + random.nextInt();
        String phone = "123456_" + random.nextInt();
        String email = random.nextInt() + "_@mail.com";
        String password = "PASSWORD_" + random.nextInt();
        String role = UserRole.ROLE_USER.name();

        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .isDeleted(random.nextBoolean())
                .password(password)
                .permissions(permissions)
                .role(role)
                .build();
    }

    public List<User> getUserList(int minCount, int maxCount) {
        long count = random.nextLong(minCount, maxCount);

        List<User> userList = new ArrayList<>();
        while (count >= 0) {
            userList.add(getUser());
            count--;
        }

        return userList;
    }

    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.firstName());
        userEntity.setLastName(user.lastName());
        userEntity.setPhone(user.phone());
        userEntity.setEmail(user.email());
        userEntity.setDeleted(user.isDeleted());
        userEntity.setRole(UserRole.valueOf(user.role()));
        userEntity.setPassword(user.password());
        userEntity.setPermissions(new ArrayList<>());
        return userEntity;
    }
}
