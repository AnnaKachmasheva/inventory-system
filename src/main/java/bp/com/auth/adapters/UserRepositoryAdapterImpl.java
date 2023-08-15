package bp.com.auth.adapters;

import bp.com.auth.exeptions.NoUserFoundException;
import bp.com.auth.exeptions.UserAlreadyExistException;
import bp.com.auth.mappers.User2UserEntityMapper;
import bp.com.auth.mappers.UserEntity2UserMapper;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.models.request.LoginRequest;
import bp.com.auth.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRepositoryAdapterImpl implements UserRepositoryAdapter {

    private final UserEntityRepository userEntityRepository;

    private final UserEntity2UserMapper userEntity2UserMapper;
    private final User2UserEntityMapper user2UserEntityMapper;
    final AuthenticationManager authenticationManager;

    @Override
    public User login(LoginRequest loginRequest) {
        String email = loginRequest.email();

        //todo fix error
        Optional<UserEntity> userEntityOptional = userEntityRepository.findByEmailIgnoreCase(email);

        if (userEntityOptional.isEmpty())
            throw new UserAlreadyExistException(email);

        UserEntity userEntity = userEntityOptional.get();
        return userEntity2UserMapper.toUser(userEntity);
    }

    @Override
    public User create(User user) {
        String email = user.email();
        Optional<UserEntity> userEntityOptional = userEntityRepository.findByEmailIgnoreCase(email);
        if (userEntityOptional.isPresent())
            throw new UserAlreadyExistException(email);

        UserEntity userEntity = user2UserEntityMapper.toUserEntity(user);
        UserEntity savedUserEntity = userEntityRepository.save(userEntity);

        return userEntity2UserMapper.toUser(savedUserEntity);
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
