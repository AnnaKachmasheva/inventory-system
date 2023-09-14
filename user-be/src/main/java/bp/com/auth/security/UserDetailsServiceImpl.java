package bp.com.auth.security;

import bp.com.auth.adapters.UserRepositoryAdapter;
import bp.com.auth.models.domain.User;
import bp.com.auth.models.entity.UserEntity;
import bp.com.auth.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity userEntity = repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", email)));

        List<SimpleGrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole().name()));
        return mapUserToCustomUserDetails(userEntity, authorities);
    }

    private CustomUserDetails mapUserToCustomUserDetails(UserEntity user, List<SimpleGrantedAuthority> authorities) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setId(user.getId());
        customUserDetails.setEmail(user.getEmail());
        customUserDetails.setPassword(user.getPassword());
        customUserDetails.setFirstName(user.getFirstName());
        customUserDetails.setLastName(user.getLastName());
        customUserDetails.setPhone(user.getPhone());
        customUserDetails.setAuthorities(authorities);
        return customUserDetails;
    }
}
