package com.darien.app.presentacion;

import com.darien.app.datos.EstudianteDAO;
import com.darien.app.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //Se crea una instance clase servicio
        var estudianteDao = new EstudianteDAO();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar operacion " + e.getMessage());
            }
            System.out.println();
        }//fin while
    }

    private static void mostrarMenu() {
        System.out.println("""
                ***Sistem de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opción: 
                """);
    }
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de estudiantes...");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> { //Buscar estudiante por id
                System.out.println("Introduce el id estudiante a buscar");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante1 = new Estudiante(idEstudiante);
                System.out.println("Estudiante antes de la busqueda: "  + estudiante1);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
                if(encontrado){
                    System.out.println("Estudiante encontrado: " + estudiante1);
                }else{
                    System.out.println("No se encontro estudainte" + estudiante1.getIdEstudiante());
                }
            }
            case 3 -> {//Agregar estudiante
                System.out.print("Introduce el nombre del estudiante: ");
                var nombreEstudiante = consola.nextLine();
                System.out.print("Introduce el apellido del estudiante: ");
                var apellidoEstudiante = consola.nextLine();
                System.out.print("Introduce el numero del estudiante: ");
                var numeroEstudiante = consola.nextLine();
                System.out.print("Introduce el email del estudiante: ");
                var emailEstudiante = consola.nextLine();
                var nuevoEstudiante = new Estudiante(
                        nombreEstudiante,
                        apellidoEstudiante,
                        numeroEstudiante,
                        emailEstudiante
                );
                var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
                if(agregado){
                    System.out.println("Estudiante agregado:" + nuevoEstudiante);
                }else{
                    System.out.println("No se agrego el estudiante" + nuevoEstudiante);
                }
            }
            case 4 -> {//Modificar estudiante
                System.out.println("Introduce el id estudiante a buscar");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Introduce el nombre del estudiante: ");
                var nombreEstudiante = consola.nextLine();
                System.out.print("Introduce el apellido del estudiante: ");
                var apellidoEstudiante = consola.nextLine();
                System.out.print("Introduce el numero del estudiante: ");
                var numeroEstudiante = consola.nextLine();
                System.out.print("Introduce el email del estudiante: ");
                var emailEstudiante = consola.nextLine();
                var nuevoEstudiante = new Estudiante(
                        idEstudiante,
                        nombreEstudiante,
                        apellidoEstudiante,
                        numeroEstudiante,
                        emailEstudiante
                );
                var modificado = estudianteDAO.modificarEstudiante(nuevoEstudiante);
                if(modificado){
                    System.out.println("Estudiante modificado:" + nuevoEstudiante);
                }else{
                    System.out.println("No se agrego el estudiante" + nuevoEstudiante);
                }
            }
            case 5 -> {//Eliminar estudiante
                System.out.print("Introduce el id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var nuevoEstudiante = new Estudiante(idEstudiante, "Darien", "Romero", "941418371", "darien.r.leiva@gmail.com");
                var modificado = estudianteDAO.eliminar(nuevoEstudiante);
                if(modificado){
                    System.out.println("Estudiante eliminado:" + nuevoEstudiante);
                }else{
                    System.out.println("No se agrego el estudiante" + nuevoEstudiante);
                }
            }
            case 6 -> {
                salir = true;
            }
        }
        return salir;
    }
}