package mappers;

import bp.com.auth.entity.PermissionEntity;
import bp.com.auth.entity.UserEntity;
import bp.com.auth.entity.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private final Random random = new Random();
    private final String[] PERMISSION_NAMES = {"UPDATE_USER", "ADD_USER", "DELETE_USER", "VIEW_USER"};


    public PermissionEntity getPermissionEntity() {
        Long id = random.nextLong(0, 1000);
        int namePosition = random.nextInt(0, PERMISSION_NAMES.length - 1);

        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setId(id);
        permissionEntity.setName(PERMISSION_NAMES[namePosition]);

        return permissionEntity;
    }

    public List<PermissionEntity> getPermissionEntityList(int minCount, int maxCount) {
        long count = random.nextLong(minCount, maxCount);

        List<PermissionEntity> permissionEntities = new ArrayList<>();
        while (count >= 0) {
            permissionEntities.add(getPermissionEntity());
            count--;
        }

        return permissionEntities;
    }

    public UserEntity getUserEntity() {
        List<PermissionEntity> permissionEntities = getPermissionEntityList(0, 10);
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

}
