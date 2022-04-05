package mx.edu.utez.sda.SSP01.repository;

import mx.edu.utez.sda.SSP01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Role, Integer> {
    Role getByRolNameEquals(String name);
}
