package com.edutech.cl.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // ID del estudiante
    private Long cursoId;   // ID del curso
    private LocalDate fechaInscripcion;
    private String estado;  // activo, completado, suspendido
}