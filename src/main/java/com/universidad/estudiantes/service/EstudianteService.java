package com.universidad.estudiantes.service;

import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    public Estudiante buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado: " + id));
    }

    @Transactional
    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public boolean correoDuplicado(Estudiante estudiante) {
        if (estudiante.getCorreo() == null || estudiante.getCorreo().isBlank()) {
            return false;
        }
        if (estudiante.getId() == null) {
            return repo.existsByCorreoIgnoreCase(estudiante.getCorreo());
        }
        return repo.existsByCorreoIgnoreCaseAndIdNot(estudiante.getCorreo(), estudiante.getId());
    }

    @Transactional
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<Estudiante> buscarPorCarrera(String carrera) {
        return repo.findByCarreraIgnoreCase(carrera);
    }

    public List<Estudiante> buscarPorNombreOApellido(String nombre, String apellido) {
        return repo.findByNombreContainingOrApellidoContaining(nombre, apellido);
    }
}
