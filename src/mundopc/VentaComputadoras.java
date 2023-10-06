package mundopc;

import mundopc.modelo.*;

public class VentaComputadoras {
    public static void main(String[] args) {
      // Crear objetos
        Raton ratonLenovo = new Raton("bluetooth", "Lenovo");
//        System.out.println(ratonLenovo);
        Teclado tecladoLenovo = new Teclado("bluetooth", "Lenovo");
//        System.out.println(tecladoLenovo);
        Monitor monitorLenovo = new Monitor("Lenovo", 27);
//        System.out.println(monitorLenovo);
        //Creamos un objeto de tipo Computadora
        Computadora computadoraLenovo = new Computadora(
          "Computadora Lenovo",
          monitorLenovo,
          tecladoLenovo,
          ratonLenovo
        );
        System.out.println(computadoraLenovo);
        // Objeto computadora
        Monitor monitorDell = new Monitor("Dell", 15);
        Teclado tecladoDell = new Teclado("usb", "Dell");
        Raton ratonDell = new Raton("usb", "Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell", monitorDell, tecladoDell, ratonDell);
        // Creamos una orden
        Orden order1 = new Orden();
        order1.agregarComputadora(computadoraLenovo);
        order1.agregarComputadora(computadoraDell);
        order1.mostrarOrden();

        // Computadora Mac
        Monitor monitorMac = new Monitor("Mac", 27);
        Teclado tecladoMac = new Teclado("bluetooth", "Mac");
        Raton ratonMac = new Raton("bluetooth", "Mac");
        Computadora computadoraIMac = new Computadora("iMac", monitorMac, tecladoMac, ratonMac);
        Orden order2 = new Orden();
        order2.agregarComputadora(computadoraIMac);
        order2.agregarComputadora(computadoraDell);
        order2.agregarComputadora(computadoraLenovo);
        System.out.println();


    }
}