package codigoabierto.tareas;

import codigoabierto.tareas.presentacion.SistemaTareasFX;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {
		//Llamamos a SistemaTareasFX
		Application.launch(SistemaTareasFX.class, args);
	}

}
