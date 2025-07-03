package com.edutech.cl.services;

import com.edutech.cl.model.Curso;
import com.edutech.cl.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepositorio;

    public List<Curso> getCursos() {
        return cursoRepositorio.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepositorio.findById(id);
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    public Curso actualizarCurso(Long id, Curso cursoDetails) {
        Curso curso = cursoRepositorio.findById(id).orElseThrow();
        curso.setTitulo(cursoDetails.getTitulo());
        curso.setPrecio(cursoDetails.getPrecio());
        curso.setDescripcion(cursoDetails.getDescripcion());
        curso.setActivo(cursoDetails.getActivo());
        return cursoRepositorio.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepositorio.deleteById(id);
    }
}
