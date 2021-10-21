package castedo.dev.mymoneycheckback.user.infra.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String username;
    private String email;
    private String password;

}
