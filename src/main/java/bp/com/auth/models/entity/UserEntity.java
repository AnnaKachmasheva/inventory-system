package bp.com.auth.models.entity;

import bp.com.auth.models.entity.enums.Permission;
import bp.com.auth.models.entity.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "APP_USER")
public class UserEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private List<Permission> permissions;
//
//    @OneToMany(mappedBy = "user")
//    private List<TokenEntity> tokens;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    private String password;

    private boolean isDeleted;

}
