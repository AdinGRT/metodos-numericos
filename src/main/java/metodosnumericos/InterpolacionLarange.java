package metodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterpolacionLarange {

    private List<Coordenada> puntosConocidos;

    private int n; // Cantidad de puntos conocidos
    private double[] x, y; // Puntos conocidos
    private List<Polinomio> polinomiosLiDeX;
    private Polinomio polinomioLarange;

    public InterpolacionLarange() {
    }

    public void iterar(int n) {
        int[] j = new int[n-1]; // Valores para cada iteracion 0 ... n-1    j != i
        int contador;
        double[] coeficientes;

        for (int i = 0; i < n; i++) {
            System.out.println("Test i = " + i);
            contador = 0;
            for (int k = 0; k < n; k++) {
                if (i != k) {
                    j[contador] = k;
                    System.out.println("Test j = " + j[contador]);
                    contador++;
                }
            }

            //MULTIPLICAR EL ENUMERADOR
            for (int k = 0; k < j.length; k++) {
                
            }
        }
    }



    public void setX() {
        this.x = new double[this.puntosConocidos.size()];
        for (int i = 0; i < this.puntosConocidos.size(); i++) {
            this.x[i] = this.puntosConocidos.get(i).getX();
        }
    }

    public void setY() {
        this.y = new double[this.puntosConocidos.size()];
        for (int i = 0; i < this.puntosConocidos.size(); i++) {
            this.y[i] = this.puntosConocidos.get(i).getY();
        }
    }

    public int getN() {
        if(puntosConocidos == null) {
            this.n = 0;
        } else {
            n = puntosConocidos.size();
        }
        return n;
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

    public void imprimirXY() {
        setX();
        setY();
        for (int i = 0; i < this.x.length; i++) {
            System.out.println("X"+i+" = "+this.x[i]);
        }
        for (int i = 0; i < this.y.length; i++) {
            System.out.println("F(X"+i+") = "+this.y[i]);
        }
    }

}
