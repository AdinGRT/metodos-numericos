package metodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterpolacionLarange {

    List<Coordenada> puntosConocidos;

    public InterpolacionLarange() {
    }

    public void capturarPuntos() {
        //MENU EN CONSOLA PARA CAPTURAR DATOS

        puntosConocidos = new ArrayList<>();
        Scanner leer = new Scanner(System.in); //Para capturar datos del teclado
        String op; //Opcion para continuar S = si || N = no
        double x, y; //Variables temporales para almacenar coordenadas capturadas

        System.out.println("PORFAVOR INGRESE LOS PUNTOS CONOCIDOS: ");
        System.out.println("");

        do {
            System.out.println("Ingrese coordenada en X: ");
            x = leer.nextDouble();
            System.out.println("Ingrese coordenada en Y: ");
            y = leer.nextDouble();

            puntosConocidos.add(new Coordenada(x,y));

            System.out.println("");
            System.out.println("Desea ingresar otra coordenada? S/N: ");
            op = leer.next();
            System.out.println("");
        } while (!op.equalsIgnoreCase("n"));
    }

    public void imprimirPuntos() {
        System.out.println("PUNTOS CONOCIDOS: ");
        for (Coordenada coord : puntosConocidos) {
            System.out.print(coord.toString() + ", ");
        }
    }

}
