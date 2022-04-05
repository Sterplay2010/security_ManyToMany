package mx.edu.utez.sda.SSP01.repository;

import mx.edu.utez.sda.SSP01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User getByUsernameEquals(String username);
}
