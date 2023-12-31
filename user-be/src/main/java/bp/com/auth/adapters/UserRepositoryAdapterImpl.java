package bp.com.auth.adapters;

import bp.com.auth.exeptions.NoUserFoundException;
import bp.com.auth.exeptions.UserAlreadyExistException;
import bp.com.auth.mappers.User2UserEntityMapper;
import bp.com.auth.mappers.UserEntity2UserMapper;
import bp.com.auth.models.domain.PageUsers;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.models.request.SignInRequest;
import bp.com.auth.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapterImpl implements UserRepositoryAdapter {

    private final UserEntityRepository userEntityRepository;

    private final UserEntity2UserMapper userEntity2UserMapper;
    private final User2UserEntityMapper user2UserEntityMapper;
    final AuthenticationManager authenticationManager;

    @Override
    public User login(SignInRequest signInRequest) {
        String email = signInRequest.email();

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
    public PageUsers findAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);

        Page<UserEntity> pageUserEntities = userEntityRepository.findAll(paging);
        List<UserEntity> userEntities = pageUserEntities.getContent();
        List<User> users = userEntity2UserMapper.toUserList(userEntities);

        return PageUsers.builder()
                .content(users)
                .totalPages(pageUserEntities.getTotalPages())
                .isEmpty(pageUserEntities.isEmpty())
                .totalElements(pageUserEntities.getTotalElements())
                .build();
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
        Long idUser = user.id();
        Optional<UserEntity> userEntityOptional = userEntityRepository.findById(idUser);
        if (userEntityOptional.isEmpty())
            throw new NoUserFoundException(idUser);

        UserEntity userEntityToUpdate = user2UserEntityMapper.toUserEntity(user);
        UserEntity updatedUserEntity = userEntityRepository.save(userEntityToUpdate);
        return userEntity2UserMapper.toUser(updatedUserEntity);
    }

    @Override
    public void resetPassword(String password) {

    }

    @Override
    public User findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userEntityRepository.findByEmailIgnoreCase(email);
        if (userEntityOptional.isEmpty())
            throw new NoUserFoundException(email);

        return userEntity2UserMapper.toUser(userEntityOptional.get());
    }

}
