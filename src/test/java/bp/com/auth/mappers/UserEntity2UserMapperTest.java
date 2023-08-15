package bp.com.auth.mappers;

import bp.com.auth.Generator;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
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
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper();

        Assertions.assertNull(userEntity2UserMapper.toUser(null));
    }

    @Test
    void toUser_UserEntity_User() {
        UserEntity userEntity = generator.getUserEntity();

        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper();

        User user = userEntity2UserMapper.toUser(userEntity);

        Assertions.assertEquals(userEntity.getId(), user.id());
        Assertions.assertEquals(userEntity.getFirstName(), user.firstName());
        Assertions.assertEquals(userEntity.getLastName(), user.lastName());
        Assertions.assertEquals(userEntity.getPhone(), user.phone());
        Assertions.assertEquals(userEntity.getEmail(), user.email());
        Assertions.assertEquals(userEntity.getRole().toString(), user.role());
        Assertions.assertEquals(userEntity.isDeleted(), user.isDeleted());
        Assertions.assertEquals(userEntity.getPassword(), user.password());
        Assertions.assertEquals(userEntity.getPermissions().size(), user.permissions().size());
    }


    @Test
    void toUserList_null_emptyList() {
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper();

        Assertions.assertTrue(userEntity2UserMapper.toUserList(null).isEmpty());
    }

    @Test
    void toUserList_emptyList_emptyList() {
        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper();

        Assertions.assertTrue(userEntity2UserMapper.toUserList(new ArrayList<>()).isEmpty());
    }

    @Test
    void toUserList_UserEntityList_UserList() {
        List<UserEntity> userEntityList = generator.getUserEntityList(2, 10);

        UserEntity2UserMapper userEntity2UserMapper = new UserEntity2UserMapper();

        List<User> users = userEntity2UserMapper.toUserList(userEntityList);

        int count = userEntityList.size();
        for (int i = 0; i < count; i++) {
            UserEntity userEntity = userEntityList.get(i);
            User user = users.get(i);

            Assertions.assertEquals(userEntity.getId(), user.id());
            Assertions.assertEquals(userEntity.getFirstName(), user.firstName());
            Assertions.assertEquals(userEntity.getLastName(), user.lastName());
            Assertions.assertEquals(userEntity.getPhone(), user.phone());
            Assertions.assertEquals(userEntity.getEmail(), user.email());
            Assertions.assertEquals(userEntity.getRole().toString(), user.role());
            Assertions.assertEquals(userEntity.isDeleted(), user.isDeleted());
            Assertions.assertEquals(userEntity.getPassword(), user.password());
            Assertions.assertEquals(userEntity.getPermissions().size(), user.permissions().size());
        }
    }

}