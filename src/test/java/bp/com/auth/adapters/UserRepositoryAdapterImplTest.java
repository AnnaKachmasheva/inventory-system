package bp.com.auth.adapters;

import bp.com.auth.Generator;
import bp.com.auth.models.domain.User;
import bp.com.auth.repositories.UserEntityRepository;
import bp.com.auth.mappers.User2UserEntityMapper;
import bp.com.auth.mappers.UserEntity2UserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryAdapterImplTest {

    @Autowired
    private UserRepositoryAdapterImpl userRepositoryAdapter;

    @Mock
    private UserEntityRepository userEntityRepository;

    @Mock
    private UserEntity2UserMapper userEntity2UserMapper;

    @Mock
    private User2UserEntityMapper user2UserEntityMapper;

    private static Generator generator;

    @BeforeAll
    static void init() {
        generator = new Generator();
    }

    @Test
    void create() {
        User user = generator.getUser();
        user.setPrivileges(new ArrayList<>());

//        when(userRepositoryAdapter.create(user)).thenReturn(any(User.class));


    }
}