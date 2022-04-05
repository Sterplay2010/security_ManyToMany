package mx.edu.utez.sda.SSP01.service;

import mx.edu.utez.sda.SSP01.entity.Role;
import mx.edu.utez.sda.SSP01.entity.RolesDTO;
import mx.edu.utez.sda.SSP01.entity.User;
import mx.edu.utez.sda.SSP01.repository.RolRepository;
import mx.edu.utez.sda.SSP01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean edit(RolesDTO rolesDTO, String update){
        List<Role> rolesNew = getRoles(rolesDTO);
        User exist = userRepository.getByUsernameEquals(update);
        //exist.setUsername(user.getUsername());
        exist.setRoles(rolesNew);
        userRepository.save(exist);
        return true;
    }

    List<Role> getRoles(RolesDTO rolesDTO){
        List<Role> roles = new ArrayList<>();
        for (String nameRol: rolesDTO.getRoleList()) {
            Role authority = rolRepository.getByRolNameEquals(nameRol);
            roles.add(authority);
        }
        return roles;
    }

    public boolean delete(String username){
        User user = userRepository.getByUsernameEquals(username);
        if (user!=null){
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
