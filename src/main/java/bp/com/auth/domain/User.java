package bp.com.auth.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private String password;
    private boolean isDeleted;
    private List<Permission> permissions;

}
