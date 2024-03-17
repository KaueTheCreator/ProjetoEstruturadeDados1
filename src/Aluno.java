/*
 * KAUÊ DE SOUZA ROSA - ESTRUTURA DE DADOS 1 - 08/03/2024
 * 
 * A classe Aluno representa informações de um aluno, como matrícula e nota. 
 * Seu objetivo é armazenar e fornecer acesso controlado a esses dados. 
 * Ela possui métodos para definir e obter valores de matrícula e nota, garantindo encapsulamento dos atributos. 
 * Essa classe fornece uma estrutura simples para representar alunos em um sistema.
 */

public class Aluno {
    // Atributos privados que representam a matrícula e a nota do aluno
    private int matricula;
    private double nota;

    // Construtor da classe Aluno que recebe a matrícula e a nota como parâmetros
    public Aluno(int matricula, double nota) {
        this.matricula = matricula; // Inicializa o atributo de matrícula com o valor fornecido
        this.nota = nota; // Inicializa o atributo de nota com o valor fornecido
    }

    // Método getter para obter o valor da matrícula do aluno
    public int getMatricula() {
        return matricula; // Retorna o valor da matrícula
    }

    // Método setter para definir o valor da matrícula do aluno
    public void setMatricula(int matricula) {
        this.matricula = matricula; // Define o valor da matrícula com o valor fornecido
    }

    // Método getter para obter o valor da nota do aluno
    public double getNota() {
        return nota; // Retorna o valor da nota
    }

    // Método setter para definir o valor da nota do aluno
    public void setNota(double nota) {
        this.nota = nota; // Define o valor da nota com o valor fornecido
    }
}
