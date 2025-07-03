package com.edutech.cl.mapper;

import com.edutech.cl.dto.UsuarioCreateDTO;
import com.edutech.cl.dto.UsuarioDTO;
import com.edutech.cl.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setDireccion(usuario.getDireccion());
        dto.setTelefono(usuario.getTelefono());
        dto.setActivo(usuario.getActivo());
        return dto;
    }

    public Usuario toEntity(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        usuario.setDireccion(dto.getDireccion());
        usuario.setTelefono(dto.getTelefono());
        usuario.setActivo(true); // Por defecto activo
        return usuario;
    }

    public Usuario toEntityFromDTO(UsuarioDTO dto) {
    if (dto == null) return null;
    Usuario usuario = new Usuario();
    usuario.setId(dto.getId());
    usuario.setNombre(dto.getNombre());
    usuario.setEmail(dto.getEmail());
    usuario.setRol(dto.getRol());
    usuario.setDireccion(dto.getDireccion());
    usuario.setTelefono(dto.getTelefono());
    usuario.setActivo(dto.getActivo());
    return usuario;
    }
    
}