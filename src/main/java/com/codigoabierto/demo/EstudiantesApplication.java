package com.codigoabierto.demo;

import com.codigoabierto.demo.modelo.Estudiante;
import com.codigoabierto.demo.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		//Levantar la fabrica de String
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada");
	}

	//Salto de linea compatible con cualquier SO
	String nl = System.lineSeparator();

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "ejecutando metodo run de Spring..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		//Se crea una instance clase servicio
		while(!salir){
			try{
				mostrarMenu();
				salir = ejecutarOpciones(consola);
			}catch(Exception e){
				System.out.println("Ocurrio un error al ejecutar operacion " + e.getMessage());
			}
			logger.info(nl);
		}//fin while
	}
	private void mostrarMenu() {
		logger.info(nl + """
                ***Sistem de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opción: 
                """ + nl);
	}
	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> { //Listar estudiantes
				logger.info(nl + "Listado de estudiantes..." + nl);
				var estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
			case 2 -> { //Buscar estudiante por id
				logger.info("Introduce el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante.toString() + nl);
				}else{
					logger.info("No se encontro estudainte" + idEstudiante + nl);
				}
			}
			case 3 -> {//Agregar estudiante
				logger.info("Introduce el nombre del estudiante: ");
				var nombreEstudiante = consola.nextLine();
				logger.info("Introduce el apellido del estudiante: ");
				var apellidoEstudiante = consola.nextLine();
				logger.info("Introduce el numero del estudiante: ");
				var numeroEstudiante = consola.nextLine();
				logger.info("Introduce el email del estudiante: ");
				var emailEstudiante = consola.nextLine();
				var nuevoEstudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, numeroEstudiante, emailEstudiante);
				estudianteServicio.guardarEstudiante(nuevoEstudiante);
				logger.info("Estudiante agregado:" + nuevoEstudiante);
			}
			case 4 -> {//Modificar estudiante
				logger.info("Introduce el id estudiante a buscar");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Introduce el nombre del estudiante: ");
					var nombreEstudiante = consola.nextLine();
					logger.info("Introduce el apellido del estudiante: ");
					var apellidoEstudiante = consola.nextLine();
					logger.info("Introduce el numero del estudiante: ");
					var numeroEstudiante = consola.nextLine();
					logger.info("Introduce el email del estudiante: ");
					var emailEstudiante = consola.nextLine();
					var nuevoEstudiante = new Estudiante(
							estudiante.getIdEstudiante(),
							nombreEstudiante,
							apellidoEstudiante,
							numeroEstudiante,
							emailEstudiante
					);
					estudianteServicio.guardarEstudiante(nuevoEstudiante);
					logger.info("Estudiante modificado: " + nuevoEstudiante);
				}else{
					logger.info("Estudiante no encontrado con id " + idEstudiante + nl);
				}
			}
			case 5 -> {//Eliminar estudiante
				logger.info("Introduce el id del estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el id a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					System.out.println("Estudiante eliminado:" + estudiante.toString());
				}else{
					logger.info("Estudiante no encontrado con id: " + idEstudiante);
				}
			}
			case 6 -> {
				salir = true;
			}
		}
		return salir;
	}
}
