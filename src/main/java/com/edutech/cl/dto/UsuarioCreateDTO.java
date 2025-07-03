package com.edutech.cl.dto;

import com.edutech.cl.model.Usuario;
import lombok.Data;

@Data
public class UsuarioCreateDTO {
    private String nombre;
    private String email;
    private String password;
    private Usuario.Rol rol;
    private String direccion;
    private String telefono;
}