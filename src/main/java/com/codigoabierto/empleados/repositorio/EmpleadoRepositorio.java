package com.codigoabierto.empleados.repositorio;

import com.codigoabierto.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
