package bp.com.auth.security;

import bp.com.auth.exeptions.NoUserFoundException;
import bp.com.auth.mappers.UserEntity2UserMapper;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.repositories.UserEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserEntityRepository userRepository;
    private UserEntity2UserMapper userEntity2UserMapper;

    @Autowired
    public UserDetailsServiceImpl(UserEntityRepository userRepository,
                                  UserEntity2UserMapper userEntity2UserMapper) {
        this.userRepository = userRepository;
        this.userEntity2UserMapper = userEntity2UserMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new NoUserFoundException(email));
        User user = userEntity2UserMapper.toUser(userEntity);

        return UserDetailsImpl.build(user);
    }
}