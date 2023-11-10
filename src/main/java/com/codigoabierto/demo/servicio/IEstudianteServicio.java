package com.codigoabierto.demo.servicio;

import com.codigoabierto.demo.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiante> listarEstudiantes();

    public Estudiante buscarEstudiantePorId(Integer idEstudiante);

    //JPA se encarga de guardar o actualizar, a partir del id
    public void guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);

}
