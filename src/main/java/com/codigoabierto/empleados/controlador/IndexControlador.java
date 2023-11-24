package com.codigoabierto.empleados.controlador;

import com.codigoabierto.empleados.modelo.Empleado;
import com.codigoabierto.empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger= LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        try {
            List<Empleado> empleados = empleadoServicio.listarEmpleados();
            logger.info("Empleados encontrados");
            empleados.forEach(empleado -> logger.info(empleado.toString()));
            //Compartimos el modelo con la vista
            modelo.put("empleados", empleados);
            return "index";//index.jsp
        }catch(Exception e){
            logger.info("Error " + e.getMessage());
            return "index";
        }
    }

    @RequestMapping(value="/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";//agregar.jsp
    }

    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado, HttpServletRequest request){
        logger.info("Empleado a agregar" + empleado.toString());
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";//redirigiar al path "/"
    }

    @RequestMapping(value="/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado a editar: " + empleado.toString());
        modelo.put("empleado", empleado);//mostrar editar.jsp
        return "editar";
    }
    @RequestMapping(value="/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado, HttpServletRequest request){
        logger.info("Empleado a editar" + empleado.toString());
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";//redirigiar al controlador al inicio
    }
    @RequestMapping(value="/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/";//redirigiar al controlador al inicio
    }
}
