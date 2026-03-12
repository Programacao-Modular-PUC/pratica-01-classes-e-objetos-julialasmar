package eximc;
import java.util.Scanner;
import java.time.LocalDate;

class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
}

class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    double altura;
    double peso;
    double imc;
    Data dataNascimento;

    public Pessoa(String nome, String sobrenome, Data dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
        this.idade = calculaIdade();
    }
    public int calculaIdade() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - dataNascimento.ano;

        if (hoje.getMonthValue() < dataNascimento.mes || (hoje.getMonthValue() == dataNascimento.mes && hoje.getDayOfMonth() < dataNascimento.dia)) {
            idade--;
        }
        return idade;
    }
    public void calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }
    public String informaObesidade() {
        if (this.imc < 18.5) {
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
        Pessoa[] pessoas = new Pessoa[10];
        int contador = 0;

        while (contador < 10) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine();

            boolean repetido = false;
            for (int i = 0; i < contador; i++) {
                if (pessoas[i].nome.equalsIgnoreCase(nome) &&
                    pessoas[i].sobrenome.equalsIgnoreCase(sobrenome)) {
                    repetido = true;
                    break;
                }
            }
            if (repetido) {
                System.out.println("Pessoa já cadastrada. Encerrando cadastro.");
                break;
            }
            System.out.print("Dia de nascimento: ");
            int dia = scanner.nextInt();

            System.out.print("Mês de nascimento: ");
            int mes = scanner.nextInt();

            System.out.print("Ano de nascimento: ");
            int ano = scanner.nextInt();

            System.out.print("Altura: ");
            double altura = scanner.nextDouble();

            System.out.print("Peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Data data = new Data(dia, mes, ano);
            Pessoa p = new Pessoa(nome, sobrenome, data, altura, peso);
            p.calculaIMC();

            pessoas[contador] = p;
            contador++;
        }
        System.out.println("\n----- RESULTADOS -----");

        for (int i = 0; i < contador; i++) {
            Pessoa p = pessoas[i];
            System.out.println("\nCadastro " + (i+1) + ":");
            System.out.println("Nome completo: " + p.nome + " " + p.sobrenome);
            System.out.println("Nome de referência: " + p.sobrenome + ", " + p.nome.toUpperCase());
            System.out.println("Idade: " + p.idade);
            System.out.println("Peso: " + p.peso);
            System.out.println("Altura: " + p.altura);
            System.out.printf("IMC: %.2f\n", p.imc);
            System.out.println("Classificação: " + p.informaObesidade());
        }
    }
}
