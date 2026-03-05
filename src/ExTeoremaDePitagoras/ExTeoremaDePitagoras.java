package ExTeoremaDePitagoras;
import java.util.Scanner;


class TrianguloRetangulo {
    double h;
    double c1;
    double c2;

    public TrianguloRetangulo(double c1, double c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    public double calculaHipotenusa() {
        h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        return h;
    }
    public double calculaArea() {
        return (c1 * c2) / 2;
    }
}


public class ExTeoremaDePitagoras {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do cateto 1: ");
        double c1 = scanner.nextDouble();
        System.out.print("Digite o valor do cateto2: ");
        double c2 = scanner.nextDouble();

        TrianguloRetangulo triangulo = new TrianguloRetangulo(c1, c2);

        double hipotenusa = triangulo.calculaHipotenusa();
        double area = triangulo.calculaArea();

        System.out.println("Hipotenusa: " + hipotenusa);
        System.out.println("Area: " + area);
    }
}