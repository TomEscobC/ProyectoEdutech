package com.edutech.cl.services;

import com.edutech.cl.dto.UsuarioCreateDTO;
import com.edutech.cl.dto.UsuarioDTO;
import com.edutech.cl.mapper.UsuarioMapper;
import com.edutech.cl.model.Usuario;
import com.edutech.cl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow();
    }

    public UsuarioDTO createUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioCreateDTO);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioCreateDTO usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setPassword(usuarioDetails.getPassword());
        usuario.setRol(usuarioDetails.getRol());
        usuario.setDireccion(usuarioDetails.getDireccion());
        usuario.setTelefono(usuarioDetails.getTelefono());
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}