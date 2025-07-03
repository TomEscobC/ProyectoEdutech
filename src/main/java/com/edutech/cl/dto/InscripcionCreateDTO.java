package com.edutech.cl.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InscripcionCreateDTO {
    private Long usuarioId;
    private Long cursoId;
    private LocalDate fechaInscripcion;
    private String estado;
}