package castedo.dev.mymoneycheckback.user.infra.db;

import castedo.dev.mymoneycheckback.user.infra.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
