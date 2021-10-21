package castedo.dev.mymoneycheckback.user.infra.db;

import castedo.dev.mymoneycheckback.user.application.ports.CheckIfExistsByEmailPort;
import castedo.dev.mymoneycheckback.user.application.ports.CheckIfExistsByUsernamePort;
import castedo.dev.mymoneycheckback.user.application.ports.SaveUserPort;
import castedo.dev.mymoneycheckback.user.dominio.User;
import castedo.dev.mymoneycheckback.user.infra.db.mappers.UserDbMapper;
import org.springframework.stereotype.Component;

@Component
public class PersistenceImplUser implements SaveUserPort, CheckIfExistsByUsernamePort, CheckIfExistsByEmailPort {

    private final UserRepository repository;
    private final UserDbMapper mapper;

    public PersistenceImplUser(UserRepository repository, UserDbMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(User user) {
        repository.save(mapper.toDb(user));
    }

    @Override
    public boolean checkUsername(String username) {

        return repository.existsByUsername(username);
    }

    @Override
    public boolean checkEmail(String email) {
        return repository.existsByEmail(email);
    }
}
