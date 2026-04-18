package com.universidad.estudiantes.repository;

import com.universidad.estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Consulta derivada: buscar por carrera
    List<Estudiante> findByCarreraIgnoreCase(String carrera);

    // Consulta derivada: buscar por nombre o apellido (búsqueda parcial)
    List<Estudiante> findByNombreContainingOrApellidoContaining(
            String nombre, String apellido);

    // Validaciones de correo unico
    boolean existsByCorreoIgnoreCase(String correo);

    boolean existsByCorreoIgnoreCaseAndIdNot(String correo, Long id);
}
