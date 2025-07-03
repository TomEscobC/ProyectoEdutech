package com.edutech.cl.controller;

import com.edutech.cl.dto.UsuarioCreateDTO;
import com.edutech.cl.dto.UsuarioDTO;
import com.edutech.cl.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return usuarioService.createUsuario(usuarioCreateDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioCreateDTO usuarioDetails) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarioDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}