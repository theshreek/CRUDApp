package com.shreek.crudapp.dto;

import com.shreek.crudapp.model.Role;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;
@Data
@Hidden

public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;

    public UserDTO(int id, String firstname, String lastname, String email, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

}
