package com.edutech.cl.controller;

import com.edutech.cl.dto.InscripcionCreateDTO;
import com.edutech.cl.dto.InscripcionDTO;
import com.edutech.cl.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<InscripcionDTO> getAllInscripciones() {
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<InscripcionDTO> getInscripcionesByUsuario(@PathVariable Long usuarioId) {
        return inscripcionService.getInscripcionesByUsuarioId(usuarioId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<InscripcionDTO> getInscripcionesByCurso(@PathVariable Long cursoId) {
        return inscripcionService.getInscripcionesByCursoId(cursoId);
    }

    @PostMapping
    public InscripcionDTO createInscripcion(@RequestBody InscripcionCreateDTO inscripcionDTO) {
        return inscripcionService.createInscripcion(inscripcionDTO);
    }
}