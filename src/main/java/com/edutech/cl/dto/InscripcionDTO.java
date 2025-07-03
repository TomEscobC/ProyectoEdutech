package com.edutech.cl.dto;

import com.edutech.cl.model.Inscripcion;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InscripcionDTO {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private LocalDate fechaInscripcion;
    private String estado;
}