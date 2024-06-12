package metodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        InterpolacionLarange interpolacionLarange = new InterpolacionLarange();

        //CAPTURA PUNTOS CONOCIDOS POR CONSOLA
        interpolacionLarange.capturarPuntos();

        //MUESTRA PUNTOS CONOCIDOS EN CONSOLA
        interpolacionLarange.imprimirPuntos();


    }
}
