package mx.edu.utez.sda.SSP01.control;

import mx.edu.utez.sda.SSP01.entity.Role;
import mx.edu.utez.sda.SSP01.entity.RolesDTO;
import mx.edu.utez.sda.SSP01.entity.User;
import mx.edu.utez.sda.SSP01.service.RoleService;
import mx.edu.utez.sda.SSP01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class ControlUser {

    Logger logger = LoggerFactory.getLogger(ControlUser.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/find-all")
    @Secured("ROLE_ADMIN")
    public String findAll() {
        logger.trace("TRACE level");
        logger.debug("DEBUG level");
        logger.error("ERROR level");
        logger.warn("WARN level");
        logger.info("INFO level");
        return "user/find-all";
    }

    @GetMapping("/create")
    @Secured("ROLE_ADMIN")
    public String create(Model model) {
        model.addAttribute("User", new User());
        model.addAttribute("UserUpdate", new User());
        model.addAttribute("Usuarios", userService.getAll());
        model.addAttribute("Roles", roleService.getAll());
        model.addAttribute("rolesDTO",new RolesDTO(new ArrayList<>()));
        return "user/create";
    }

    @PostMapping("/save")
    @Secured("ROLE_ADMIN")
    public String save(@ModelAttribute("User") User user, @ModelAttribute RolesDTO rolesDTO) {
        List<Role> roles = new ArrayList<>();
        for (String nameRol: rolesDTO.getRoleList()) {
            Role authority = roleService.getOneByName(nameRol);
            roles.add(authority);
        }
        user.setRoles(roles);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        user.setEnabled(true);
        userService.save(user);
        return "redirect:/users/create";
    }

    @PostMapping("/update/{userName}")
    @Secured("ROLE_ADMIN")
    public String update(@ModelAttribute RolesDTO rolesDTO, @PathVariable("userName") String update){
        System.out.println("Usuario: " + update);
        userService.edit(rolesDTO, update);
        return "redirect:/users/create";
    }

    @GetMapping("/delete/{username}")
    @Secured("ROLE_ADMIN")
    public String delete(@PathVariable("username") String username) {
        userService.delete(username);
        return "redirect:/users/create";
    }
}
