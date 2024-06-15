package metodosnumericos;

import java.util.Scanner;

public class Polinomio {
    private double[] coeficientes;

    public Polinomio()
    {
    }

    public Polinomio (double... coef) {
        coeficientes = new double[coef.length];
        for (int i = coeficientes.length - 1; i >= 0; --i) {
            coeficientes[i] = coef[coeficientes.length-1-i];
            System.out.println("Test ->     Coeficiente de x^" + i + ": "+coeficientes[i]);
        }
    }

    public Polinomio(int grado)
        {
            if ( grado <= 0 ) grado = 0;
            coeficientes = new double[grado + 1];
        }

        public int grado()
        {
            return coeficientes.length - 1;
        }

        public double coeficiente(int i)
        {
            return i < coeficientes.length ? coeficientes[i] : 0;
        }

        public void leer() {
            Scanner leer = new Scanner(System.in);

            System.out.println("Grado (n): ");
            int n = leer.nextInt();
            coeficientes = new double[n + 1];
            for (int i = coeficientes.length - 1; i >= 0; --i) {
                System.out.println("Coeficiente de x^" + i + ": ");
                coeficientes[i] = leer.nextLong();
            }
        }

        public void imprimir()
        {
            for ( int i = grado(); i >= 0; --i )
            {
                if ( coeficientes[i] != 0 )
                {
                    if ( i != grado() ) System.out.print(" + ");
                    if ( coeficientes[i] != 1 || i == 0 ) System.out.print(coeficientes[i]);
                    if ( i > 0 ) System.out.print("x");
                    if ( i > 1 ) System.out.print("^" + i);
                }
            }
        }

        Polinomio sumar(Polinomio otro)
        {
            int grado = Math.max( grado(), otro.grado() );
            Polinomio resultado = new Polinomio(grado);
            for ( int i = 0; i <= grado; ++i )
                resultado.coeficientes[i] = coeficiente(i) + otro.coeficiente(i);

            return resultado;
        }

        Polinomio restar(Polinomio otro)
        {
            int grado = Math.max( grado(), otro.grado() );
            Polinomio resultado = new Polinomio(grado);
            for ( int i = 0; i <= grado; ++i )
                resultado.coeficientes[i] = coeficiente(i) - otro.coeficiente(i);

            return resultado;
        }

        Polinomio multiplicar(Polinomio otro)
        {
            int grado = grado() + otro.grado();
            Polinomio resultado = new Polinomio(grado);
            for ( int i = 0; i <= grado(); ++i )
                for ( int j = 0; j <= otro.grado(); ++j )
                    resultado.coeficientes[i + j] += coeficiente(i) * otro.coeficiente(j);

            return resultado;
        }

        double valuarEn(double x) {
            double resultado = 0;
            for (int i = 0; i <= grado(); i++) {
                resultado = resultado + coeficiente(i) * Math.pow(x, i);
                System.out.println("Test : coeficiente("+i+") = " + coeficiente(i));
                System.out.println("Test : resultado = " + resultado);
            }
            return resultado;
        }

        public static void main(String[] args)
        {
            System.out.println("Polinomio 1");
            Polinomio polinomio1 = new Polinomio();
            polinomio1.leer();
            polinomio1.imprimir();

            System.out.println("\n\nPolinomio 2");
            Polinomio polinomio2 = new Polinomio();
            polinomio2.leer();
            polinomio2.imprimir();

            System.out.println();
            imprimirOperacion( polinomio1, polinomio2, "+", polinomio1.sumar(polinomio2) );
            imprimirOperacion( polinomio1, polinomio2, "-", polinomio1.restar(polinomio2) );
            imprimirOperacion( polinomio2, polinomio1, "-", polinomio2.restar(polinomio1) );
            imprimirOperacion( polinomio1, polinomio2, "*", polinomio1.multiplicar(polinomio2) );

            System.out.println("Polinomio 1 F(2) = " + polinomio1.valuarEn(2));


        }

        public static void imprimirOperacion(Polinomio a, Polinomio b, String op, Polinomio resultado)
        {
            System.out.print("\n(");
            a.imprimir();
            System.out.print(") " + op + " (");
            b.imprimir();
            System.out.print(") = ");
            resultado.imprimir();
            System.out.println();
        }

}
