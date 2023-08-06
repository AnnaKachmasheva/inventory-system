package mappers;

import bp.com.auth.domain.Permission;
import bp.com.auth.entity.PermissionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PermissionEntity2PermissionMapperTest {

    private static Generator generator;

    @BeforeAll
    static void init() {
        generator = new Generator();
    }

    @Test
    void toPermission_null_null() {
        PermissionEntity2PermissionMapper mapper = new PermissionEntity2PermissionMapper();
        Assertions.assertNull(mapper.toPermission(null));
    }

    @Test
    void toPermission_PermissionEntity_true() {
        PermissionEntity2PermissionMapper mapper = new PermissionEntity2PermissionMapper();

        PermissionEntity permissionEntity = generator.getPermissionEntity();
        Permission permission = mapper.toPermission(permissionEntity);

        Assertions.assertEquals(permissionEntity.getId(), permission.getId());
        Assertions.assertEquals(permissionEntity.getName(), permission.getName());
    }

    @Test
    void toPermissionSet_null_emptyList() {
        PermissionEntity2PermissionMapper mapper = new PermissionEntity2PermissionMapper();
        Assertions.assertEquals(0, mapper.toPermissionSet(null).size());
    }


    @Test
    void toPermissionSet_emptyList_emptyList() {
        PermissionEntity2PermissionMapper mapper = new PermissionEntity2PermissionMapper();
        Assertions.assertTrue(mapper.toPermissionSet(new ArrayList<>()).isEmpty());
    }


    @Test
    void toPermissionSet_setPermissionEntities_setPermissions() {
        List<PermissionEntity> permissionEntityList = generator.getPermissionEntityList(2, 10);

        PermissionEntity2PermissionMapper mapper = new PermissionEntity2PermissionMapper();
        List<Permission> permissions = mapper.toPermissionSet(permissionEntityList);

        int count = permissionEntityList.size();
        for (int i = 0; i < count; i++) {
            PermissionEntity permissionEntity = permissionEntityList.get(i);
            Permission permission = permissions.get(i);

            Assertions.assertEquals(permissionEntity.getId(), permission.getId());
            Assertions.assertEquals(permissionEntity.getName(), permission.getName());
        }
    }

}