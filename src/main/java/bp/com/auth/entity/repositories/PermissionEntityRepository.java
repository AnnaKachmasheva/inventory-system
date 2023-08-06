package bp.com.auth.entity.repositories;

import bp.com.auth.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionEntityRepository extends JpaRepository<PermissionEntity, Long> {
}
