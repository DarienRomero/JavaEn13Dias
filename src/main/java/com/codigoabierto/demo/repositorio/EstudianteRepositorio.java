package com.codigoabierto.demo.repositorio;

import com.codigoabierto.demo.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

}
