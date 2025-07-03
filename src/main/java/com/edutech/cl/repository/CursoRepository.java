package com.edutech.cl.repository;

import com.edutech.cl.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByActivoTrue();
}
