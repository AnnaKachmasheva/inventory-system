package bp.com.auth.entity;

import bp.com.auth.entity.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "PERMISSIONS")
public class PermissionEntity extends AbstractEntity {

    private String name;

}