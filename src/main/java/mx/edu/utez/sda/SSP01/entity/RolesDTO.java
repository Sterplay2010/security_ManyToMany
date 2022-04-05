package mx.edu.utez.sda.SSP01.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RolesDTO {
    private List<String> roleList;

    public RolesDTO(List<String> roleList) {
        this.roleList = roleList;
    }
}
