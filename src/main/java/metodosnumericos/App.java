package metodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        List<Coordenada> puntosConocidos;
        puntosConocidos = new ArrayList<>();
        puntosConocidos.add(new Coordenada(0, 1));
        puntosConocidos.add(new Coordenada(1, 3));
        puntosConocidos.add(new Coordenada(2, 0));
        InterpolacionLarange interpolacionLarange = new InterpolacionLarange(puntosConocidos);



        //CAPTURA PUNTOS CONOCIDOS POR CONSOLA
//        interpolacionLarange.capturarPuntos();

        //MUESTRA PUNTOS CONOCIDOS EN CONSOLA
        interpolacionLarange.imprimirPuntos();

        System.out.println("n = " + interpolacionLarange.getN());

        interpolacionLarange.imprimirXY();

        interpolacionLarange.iterar(interpolacionLarange.getN());

    }
}
