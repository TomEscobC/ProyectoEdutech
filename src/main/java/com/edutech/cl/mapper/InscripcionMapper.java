package com.edutech.cl.mapper;

import com.edutech.cl.dto.InscripcionCreateDTO;
import com.edutech.cl.dto.InscripcionDTO;
import com.edutech.cl.model.Inscripcion;
import org.springframework.stereotype.Component;

@Component
public class InscripcionMapper {

    public InscripcionDTO toDTO(Inscripcion inscripcion) {
        if (inscripcion == null) return null;

        InscripcionDTO dto = new InscripcionDTO();
        dto.setId(inscripcion.getId());
        dto.setUsuarioId(inscripcion.getUsuarioId());
        dto.setCursoId(inscripcion.getCursoId());
        dto.setFechaInscripcion(inscripcion.getFechaInscripcion());
        dto.setEstado(inscripcion.getEstado());
        return dto;
    }

    public Inscripcion toEntity(InscripcionCreateDTO dto) {
        if (dto == null) return null;

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setUsuarioId(dto.getUsuarioId());
        inscripcion.setCursoId(dto.getCursoId());
        inscripcion.setFechaInscripcion(dto.getFechaInscripcion());
        inscripcion.setEstado(dto.getEstado());
        return inscripcion;
    }
}