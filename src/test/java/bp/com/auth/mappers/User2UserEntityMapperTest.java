package bp.com.auth.mappers;

import bp.com.auth.Generator;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class User2UserEntityMapperTest {

    private static Generator generator;

    @BeforeAll
    static void init() {
        generator = new Generator();
    }


    @Test
    void toUserEntity_null_null() {
        User2UserEntityMapper user2UserEntityMapper = new User2UserEntityMapper();

        Assertions.assertNull(user2UserEntityMapper.toUserEntity(null));
    }

    @Test
    void toUserEntity_User_UserEntity() {
        User user = generator.getUser();

        User2UserEntityMapper user2UserEntityMapper = new User2UserEntityMapper();

        UserEntity userEntity = user2UserEntityMapper.toUserEntity(user);

        Assertions.assertEquals(user.firstName(), userEntity.getFirstName());
        Assertions.assertEquals(user.lastName(), userEntity.getLastName());
        Assertions.assertEquals(user.phone(), userEntity.getPhone());
        Assertions.assertEquals(user.email(), userEntity.getEmail());
        Assertions.assertEquals(user.role(), userEntity.getRole().name());
        Assertions.assertEquals(user.isDeleted(), userEntity.isDeleted());
        Assertions.assertEquals(user.password(), userEntity.getPassword());
        Assertions.assertEquals(user.permissions().size(), userEntity.getPermissions().size());
    }


    @Test
    void toUserEntityList_null_emptyList() {
        User2UserEntityMapper user2UserEntityMapper = new User2UserEntityMapper();

        Assertions.assertTrue(user2UserEntityMapper.toUserEntityList(null).isEmpty());
    }

    @Test
    void toUserEntityList_emptyList_emptyList() {
        User2UserEntityMapper user2UserEntityMapper = new User2UserEntityMapper();

        Assertions.assertTrue(user2UserEntityMapper.toUserEntityList(new ArrayList<>()).isEmpty());
    }

    @Test
    void toUserEntityList_UserList_UserEntityList() {
        List<User> userList = generator.getUserList(2, 10);

        User2UserEntityMapper user2UserEntityMapper = new User2UserEntityMapper();

        List<UserEntity> userEntities = user2UserEntityMapper.toUserEntityList(userList);

        int count = userList.size();
        for (int i = 0; i < count; i++) {
            UserEntity userEntity = userEntities.get(i);
            User user = userList.get(i);

            Assertions.assertEquals(user.firstName(), userEntity.getFirstName());
            Assertions.assertEquals(user.lastName(), userEntity.getLastName());
            Assertions.assertEquals(user.phone(), userEntity.getPhone());
            Assertions.assertEquals(user.email(), userEntity.getEmail());
            Assertions.assertEquals(user.role(), userEntity.getRole().name());
            Assertions.assertEquals(user.isDeleted(), userEntity.isDeleted());
            Assertions.assertEquals(user.password(), userEntity.getPassword());
            Assertions.assertEquals(user.permissions().size(), userEntity.getPermissions().size());
        }
    }

}