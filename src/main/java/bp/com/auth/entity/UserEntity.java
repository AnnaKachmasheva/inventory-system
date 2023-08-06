package bp.com.auth.entity;

import bp.com.auth.entity.abstracts.AbstractEntity;
import bp.com.auth.entity.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class UserEntity extends AbstractEntity {

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToMany
    private List<PermissionEntity> permissions;

    private String firstName;

    private String lastName;

    private String phone;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private boolean isDeleted;

}
