import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        ConsultaClima consultaClima= new ConsultaClima();

        while (opcion!=7){
        System.out.println("\nBienvenido a CIELOSCOPIO (tu ventana digital al clima del mundo)");
        System.out.println("""
                \n*********************************************************
                Elija una ciudad para obtener los datos meteorólogicos:
                1- Bogotá
                2- Buenos Aires
                3- Ciudad de México
                4- Lima
                5- Santiago de Chile
                6- Deseo consultar otra ciudad
                7- Salir
                *********************************************************
                 """);
        System.out.println("Elija una opción basada en el número: ");

        try {
        opcion = lectura.nextInt();
        } catch (InputMismatchException e) {
        System.out.println("Ingrese un número válido.");
        lectura.nextLine();
        opcion = 0;
        continue;
        }

        switch (opcion){
            case 1 ->{
               var respuesta = consultaClima.buscaCiudad("Bogota");
                System.out.println(respuesta);
            }
            case 2 ->{
                var respuesta = consultaClima.buscaCiudad("Buenos Aires");
                System.out.println(respuesta);
            }
            case 3 ->{
                var respuesta = consultaClima.buscaCiudad("Mexico,MX");
                System.out.println(respuesta);
            }
            case 4 ->{
                var respuesta = consultaClima.buscaCiudad("Lima");
                System.out.println(respuesta);
            }
            case 5 ->{
                var resspuesta = consultaClima.buscaCiudad("Santiago");
                System.out.println(resspuesta);
            }
            case 6 -> {
                lectura.nextLine();
                System.out.println("Escriba el nombre de la ciudad sobre la ciudad que desea consultar");
                String nombreCiudad = lectura.nextLine();
                var resspuesta = consultaClima.buscaCiudad(nombreCiudad);
                System.out.println(resspuesta);
                System.out.println("⚠ ADVERTENCIA: debido a que algunas ciudades de diferentes países tienen ");
                System.out.println("el mismo nombre, verifique que el código del país buscado sea el correcto.");
                System.out.println("* Para mayor información, obtener el resultado adecuado y ejemplos ");
                System.out.println("consulte el archivo adjunto Readme.md");
                System.out.println( "*********************************************************\n\n" );}
            case 7 -> {
            System.out.println("Saliendo del programa...");
            return;
           }
            default ->{
                System.out.println("Opción no válida, inténtelo de nuevo");
            }
        }
    }
    }
}