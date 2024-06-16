package metodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterpolacionLarange {

    private List<Coordenada> puntosConocidos;

    private int n; // Cantidad de puntos conocidos
    private double[] x, y; // Puntos conocidos
    private List<Polinomio> polinomiosXmenosXj;
    private List<Polinomio> polinomiosLiDeX;
    private Polinomio polinomioLarange;

    public InterpolacionLarange() {
    }

    public InterpolacionLarange(List<Coordenada> puntosConocidos) {
        this.puntosConocidos = puntosConocidos;
    }

    public void iterar(int n) {

        this.polinomiosLiDeX = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("");
            System.out.println("Iteracion: " + i);
            System.out.println("i = " + i);


            System.out.println(imprimirValoresJ(i));
            System.out.println("");

            this.polinomiosXmenosXj = obtenerXmenosXj(i);

            System.out.print("L" + i + "(x) = ");
            System.out.print(imprimirXmenosXj(this.polinomiosXmenosXj));
            System.out.print("  /  ");
            System.out.print(imprimirXiMenosXj(this.x, i));
            System.out.println("");

            System.out.print("L" + i + "(x) = ");
            System.out.print(multiplicativoXmenosXj(this.polinomiosXmenosXj).imprimir());
            System.out.print("  /  ");
            System.out.print(multiplicativoXiMenosXj(this.x, i));
            System.out.println("");

            this.polinomiosLiDeX.add(obtenerLiDeX(multiplicativoXmenosXj(this.polinomiosXmenosXj), multiplicativoXiMenosXj(this.x, i)));

            //MULTIPLICAR EL ENUMERADOR

            //OBTENER TODOS LOS X - Xj
        }
    }


    private String imprimirValoresJ(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("j = ");
        for (int j = 0; j < n; j++) {
            if (i != j) {
                sb.append(j);
                if (j != n-1) sb.append(", ");
            }
        }
        return sb.toString();
    }

    private List<Polinomio> obtenerXmenosXj (int i) {
        Polinomio polinomio;
        List<Polinomio>polinomiosXmenosXj = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (i != j) {
                double x = 1;
                double xj = this.x[j];
                polinomio = new Polinomio(x, xj*-1);
                polinomiosXmenosXj.add(polinomio);
            }
        }
        return polinomiosXmenosXj;
    }

    public String imprimirXmenosXj(List<Polinomio> polinomiosXmenosXj) {
        StringBuilder sb = new StringBuilder();
        for (Polinomio pol : polinomiosXmenosXj) {
            sb.append("( ");
            sb.append(pol.imprimir());
            sb.append(" ) ");
        }
        return sb.toString();
    }

    public String imprimirXiMenosXj(double[] x, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (i != j) {
                sb.append("( " + x[i] + " " + -1*x[j] + " ) ");
            }
        }
        return sb.toString();
    }

    private Polinomio multiplicativoXmenosXj(List<Polinomio> polinomiosXmenosXj) {
        Polinomio polinomioResultante = new Polinomio(1.0);
        for (Polinomio pol : polinomiosXmenosXj) {
            polinomioResultante = polinomioResultante.multiplicar(pol);
        }
        return polinomioResultante;
    }

    private double multiplicativoXiMenosXj(double[] x, int i) {
        double resultado = 1.0;
        for (int j = 0; j < n; j++) {
            if (i != j) {
                resultado = resultado * (x[i] + -1*x[j]);
            }
        }
        return resultado;
    }

    private Polinomio obtenerLiDeX (Polinomio multiplicativoXmenosXj, double denominador) {
        double multiplica = 1.0 / denominador;
        return multiplicativoXmenosXj.multiplicar(new Polinomio(multiplica));
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
