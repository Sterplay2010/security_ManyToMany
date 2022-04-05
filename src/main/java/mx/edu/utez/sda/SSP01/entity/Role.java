package mx.edu.utez.sda.SSP01.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "rol_name")
    private String rolName;
    @ManyToMany(mappedBy = "roles")
    Collection<User> users;
}
