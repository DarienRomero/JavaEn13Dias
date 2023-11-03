package com.darien.app.datos;
import com.darien.app.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.darien.app.conexion.Conexion.getConexion;

//DAO - Data Access Object
public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error al selecionar datos: " + e.getMessage());
        }finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: " + e.getMessage());
            }
        }
        return estudiantes;
    }
    //findById
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error al buscar estudiante");
        }finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Ocurrio un error al cerrar conexion");
            }

        }
        return false;

    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email) " +
                "values(?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            //Cuando es una modificacion solo se usa execute
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al agregar estudiante " + e.getMessage());
        }finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre=?, apellido=?,telefono=?, "+
                " email=? WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            //Cuando es una modificacion solo se usa execute
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar estudiante " + e.getMessage());
        }finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return false;
    }
    public boolean eliminar(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE from estudiante where id_estudiante=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            //Cuando es una modificacion solo se usa execute
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar estudiante " + e.getMessage());
        }finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();
//        //Agregar estudiante
//        var nuevoEstudiante = new Estudiante("Darien", "Romero", "942428370", "darien@evolbit.net");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if(agregado){
//            System.out.println("Estudiante agregado:" + nuevoEstudiante);
//        }else{
//            System.out.println("No se agrego el estudiante" + nuevoEstudiante);
//        }
        // Modificar estudiante
//        var nuevoEstudiante = new Estudiante(1, "Darien", "Romero", "941418371", "darien.r.leiva@gmail.com");
//        var modifiado = estudianteDao.modificarEstudiante(nuevoEstudiante);
//        if(modifiado){
//            System.out.println("Estudiante modificado:" + nuevoEstudiante);
//        }else{
//            System.out.println("No se agrego el estudiante" + nuevoEstudiante);
//        }
        // Eliminar estudiante
        var nuevoEstudiante = new Estudiante(1, "Darien", "Romero", "941418371", "darien.r.leiva@gmail.com");
        var modifiado = estudianteDao.eliminar(nuevoEstudiante);
        if(modifiado){
            System.out.println("Estudiante eliminado:" + nuevoEstudiante);
        }else{
            System.out.println("No se agrego el estudiante" + nuevoEstudiante);
        }
        // Listar los estudiantes
        System.out.println("Listato Estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);
//        //Buscar por Id
//        var estudiante1 = new Estudiante(1);
//        System.out.println("Estudiante antes de la busqueda: "  + estudiante1);
//        var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
//        if(encontrado){
//            System.out.println("Estudiante encontrado: " + estudiante1);
//        }else{
//            System.out.println("No se encontro estudainte" + estudiante1.getIdEstudiante());
//        }

    }
}
