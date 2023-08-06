package bp.com.auth.mappers;

import bp.com.auth.domain.User;
import bp.com.auth.entity.UserEntity;
import bp.com.auth.mappers.Generator;
import bp.com.auth.mappers.PermissionEntity2PermissionMapper;
import bp.com.auth.mappers.UserEntity2UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserEntity2UserMapperTest {

    private static Generator generator;

    @BeforeAll
    static void init() {
        generator = new Generator();
    }


    @Test
    void toUser_null_null() {
        PermissionEntity2PermissionMapper permissionEntity2PermissionMapper = new PermissionEntity2PermissionMapper();
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper(permissionEntity2PermissionMapper);

        Assertions.assertNull(userEntity2UserMapper.toUser(null));
    }

    @Test
    void toUser_UserEntity_User() {
        UserEntity userEntity = generator.getUserEntity();

        PermissionEntity2PermissionMapper permissionEntity2PermissionMapper = new PermissionEntity2PermissionMapper();
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper(permissionEntity2PermissionMapper);

        User user = userEntity2UserMapper.toUser(userEntity);

        Assertions.assertEquals(userEntity.getId(), user.getId());
        Assertions.assertEquals(userEntity.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userEntity.getLastName(), user.getLastName());
        Assertions.assertEquals(userEntity.getPhone(), user.getPhone());
        Assertions.assertEquals(userEntity.getEmail(), user.getEmail());
        Assertions.assertEquals(userEntity.getRole().toString(), user.getRole());
        Assertions.assertEquals(userEntity.isDeleted(), user.isDeleted());
        Assertions.assertEquals(userEntity.getPassword(), user.getPassword());
        Assertions.assertEquals(userEntity.getPermissions().size(), user.getPermissions().size());
    }


    @Test
    void toUserList_null_emptyList() {
        PermissionEntity2PermissionMapper permissionEntity2PermissionMapper = new PermissionEntity2PermissionMapper();
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper(permissionEntity2PermissionMapper);

        Assertions.assertTrue(userEntity2UserMapper.toUserList(null).isEmpty());
    }

    @Test
    void toUserList_emptyList_emptyList() {
        PermissionEntity2PermissionMapper permissionEntity2PermissionMapper = new PermissionEntity2PermissionMapper();
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper(permissionEntity2PermissionMapper);

        Assertions.assertTrue(userEntity2UserMapper.toUserList(new ArrayList<>()).isEmpty());
    }

    @Test
    void toUserList_UserEntityList_UserList() {
        List<UserEntity> userEntityList = generator.getUserEntityList(2, 10);

        PermissionEntity2PermissionMapper permissionEntity2PermissionMapper = new PermissionEntity2PermissionMapper();
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper(permissionEntity2PermissionMapper);

        List<User> users = userEntity2UserMapper.toUserList(userEntityList);

        int count = userEntityList.size();
        for (int i = 0; i < count; i++) {
            UserEntity userEntity = userEntityList.get(i);
            User user = users.get(i);

            Assertions.assertEquals(userEntity.getId(), user.getId());
            Assertions.assertEquals(userEntity.getFirstName(), user.getFirstName());
            Assertions.assertEquals(userEntity.getLastName(), user.getLastName());
            Assertions.assertEquals(userEntity.getPhone(), user.getPhone());
            Assertions.assertEquals(userEntity.getEmail(), user.getEmail());
            Assertions.assertEquals(userEntity.getRole().toString(), user.getRole());
            Assertions.assertEquals(userEntity.isDeleted(), user.isDeleted());
            Assertions.assertEquals(userEntity.getPassword(), user.getPassword());
            Assertions.assertEquals(userEntity.getPermissions().size(), user.getPermissions().size());
        }
    }


}