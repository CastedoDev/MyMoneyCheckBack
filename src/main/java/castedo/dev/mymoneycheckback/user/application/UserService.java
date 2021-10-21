package castedo.dev.mymoneycheckback.user.application;

import castedo.dev.mymoneycheckback.user.application.ports.CheckIfExistsByEmailPort;
import castedo.dev.mymoneycheckback.user.application.ports.CheckIfExistsByUsernamePort;
import castedo.dev.mymoneycheckback.user.application.ports.SaveUserPort;
import castedo.dev.mymoneycheckback.user.dominio.Token;
import castedo.dev.mymoneycheckback.user.dominio.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    private final SaveUserPort port;
    private final CheckIfExistsByEmailPort checkEmailPort;
    private final CheckIfExistsByUsernamePort checkUsernamePort;

    public UserService(PasswordEncoder passwordEncoder, TokenService tokenService, SaveUserPort port, CheckIfExistsByEmailPort checkEmailPort, CheckIfExistsByUsernamePort checkUsernamePort) {
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.port = port;
        this.checkEmailPort = checkEmailPort;
        this.checkUsernamePort = checkUsernamePort;
    }

    public Token invoke(User user){

        //TODO: Crear una respuesta de error
        if(checkEmail.checkEmail(user.getEmail())){
            System.out.println("El email existe");
        }

        if(checkUsername.checkUsername(user.getUsername())){
            System.out.println("El username existe");
        }

        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        port.save(user);

        String token = UUID.randomUUID().toString();
        Token confirmationToken = new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        tokenService.save(confirmationToken);

        return confirmationToken;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         if(!checkEmailPort.checkEmail(s)){
             throw new UsernameNotFoundException("Email not found");
         }
    }
}
