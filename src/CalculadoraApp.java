import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
            System.out.println("**** Aplicación Calculadora *****");
            //Mostramos el menu
            System.out.println("1. Suma \n2.Resta\n3. Multiplicación\n4. División\n5. Salir");
            System.out.print("Operación a realizar?: ");
            try {
                var operacion = Integer.parseInt(consola.nextLine());
                //Revisar que este dentro de las opciones mencionadas
                if (operacion >= 1 && operacion <= 4) {
                    System.out.print("Proporciona valor operando1: ");
                    var operando1 = Integer.parseInt(consola.nextLine());
                    System.out.print("Proporciona valor operando2: ");
                    var operando2 = Integer.parseInt(consola.nextLine());
                    int resultado;
                    switch (operacion) {
                        case 1: {
                            resultado = operando1 + operando2;
                            System.out.println("Resultado Suma: " + resultado);
                            break;
                        }
                        case 2: {
                            resultado = operando1 - operando2;
                            System.out.println("Resultado Resta: " + resultado);
                            break;
                        }
                        case 3: {
                            resultado = operando1 * operando2;
                            System.out.println("Resultado Multiplicación: " + resultado);
                            break;
                        }
                        case 4: {
                            resultado = operando1 / operando2;
                            System.out.println("División: " + resultado);
                            break;
                        }
                        default: {
                            System.out.println("Opción erronea:" + operacion);
                        }
                    }
                    //  var resultado = operando1 + operando2;
                    //  System.out.println("Resultant:" + resultado);
                } else if (operacion == 5) {//Salir
                    System.out.println("Hasta pronto...");
                    break;
                } else {
                    System.out.println("Opción erronea " + operacion);
                }
                // Imprimimos un salto antes de repetir el ciclo
                System.out.println();
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }//fin del try
        }//fin del while
    }//fin del main
}

