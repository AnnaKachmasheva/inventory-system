package bp.com.auth.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {

    private Long id;
    private String name;

}
