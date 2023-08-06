package adapters;

import bp.com.auth.domain.User;
import bp.com.auth.entity.UserEntity;
import bp.com.auth.entity.repositories.UserEntityRepository;
import bp.com.auth.rest.request.LoginRequest;
import exeptions.NoUserFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mappers.UserEntity2UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRepositoryAdapterImpl implements UserRepositoryAdapter {

    private final UserEntityRepository userEntityRepository;

    private final UserEntity2UserMapper userEntity2UserMapper;


    @Override
    public String login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userEntityRepository.findAll();
        return userEntity2UserMapper.toUserList(userEntities);
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> userEntityOptional = userEntityRepository.findById(id);
        if (userEntityOptional.isEmpty())
            throw new NoUserFoundException(id);
        return userEntity2UserMapper.toUser(userEntityOptional.get());
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void resetPassword(String password) {

    }

}
