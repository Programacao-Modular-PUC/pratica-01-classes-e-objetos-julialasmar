package eximc;
import java.util.Scanner;

class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    double altura;
    double peso;
    double imc;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    public void calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }
    public String informaObesidade() {
        if (this.imc < 18.5){
            return "Abaixo do peso";
        }
        if (this.imc < 25){
            return "Peso normal";
        }
        if (this.imc < 30){
            return "Sobrepeso";
        }
        if (this.imc < 35){
            return "Obesidade grau 1";
        }
        if (this.imc < 40){
            return "Obesidade grau 2";
        }
        return "Obesidade grau 3";
    }
}


public class ExIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        
        Pessoa p = new Pessoa(nome, sobrenome, idade, altura, peso);
        p.calculaIMC();
        
        System.out.println("----------Resultado----------");
        System.out.println("Nome: " + p.nome +" " + p.sobrenome); 
        System.out.println("Idade: " + p.idade);
        System.out.printf("IMC: %.2f\n", p.imc);
        System.out.println("Status: " + p.informaObesidade());
    }
}