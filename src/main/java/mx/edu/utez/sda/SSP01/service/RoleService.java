package mx.edu.utez.sda.SSP01.service;

import mx.edu.utez.sda.SSP01.entity.Role;
import mx.edu.utez.sda.SSP01.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RolRepository rolRepository;


    public List<Role> getAll(){
        return rolRepository.findAll();
    }

    public Role getOneByName(String name){
        return rolRepository.getByRolNameEquals(name);
    }


}
