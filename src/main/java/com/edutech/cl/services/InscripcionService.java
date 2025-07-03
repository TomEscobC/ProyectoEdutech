package com.edutech.cl.services;

import com.edutech.cl.dto.InscripcionCreateDTO;
import com.edutech.cl.dto.InscripcionDTO;
import com.edutech.cl.mapper.InscripcionMapper;
import com.edutech.cl.model.Inscripcion;
import com.edutech.cl.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private InscripcionMapper inscripcionMapper;

    public List<InscripcionDTO> getAllInscripciones() {
        return inscripcionRepository.findAll().stream()
                .map(inscripcionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<InscripcionDTO> getInscripcionesByUsuarioId(Long usuarioId) {
        return inscripcionRepository.findByUsuarioId(usuarioId).stream()
                .map(inscripcionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<InscripcionDTO> getInscripcionesByCursoId(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId).stream()
                .map(inscripcionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InscripcionDTO createInscripcion(InscripcionCreateDTO inscripcionDTO) {
        Inscripcion inscripcion = inscripcionMapper.toEntity(inscripcionDTO);
        return inscripcionMapper.toDTO(inscripcionRepository.save(inscripcion));
    }
}