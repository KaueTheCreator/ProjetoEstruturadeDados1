/*
 * KAUÊ DE SOUZA ROSA - ESTRUTURA DE DADOS 1 - 12/03/2024
 * 
 * A classe TesteListaAluno oferece uma interface de usuário para interagir com um sistema de gerenciamento de uma turma de alunos. 
 * Ela apresenta um menu com opções para adicionar, remover, buscar e imprimir alunos, além de verificar o tamanho da lista. 
 * Utiliza um loop para manter a interação com o usuário, integrando-se à classe ListaAluno para realizar operações sobre os dados dos alunos. 
 * Ao escolher a opção de sair, o programa é encerrado. Essa classe serve como ponto de entrada e controle para o sistema de gerenciamento da turma de alunos.
 */

import java.util.Scanner;

public class TesteListaAluno {
    public static void main(String[] args) throws Exception {
        // Criação de uma instância da classe ListaAluno para gerenciar os alunos
        ListaAluno ListaPrincipal = new ListaAluno();
        // Variável de controle para o loop principal do programa
        int segurador = 0;
        // Criação de um objeto Scanner para a entrada do usuário
        Scanner sc = new Scanner(System.in);
        // Loop principal do programa
        while (segurador == 0) {
            // Impressão do menu de opções para o usuário
            System.out.println("======= Gerenciamento da Turma de ED1 =======");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno Por Matrícula");
            System.out.println("3. Buscar Dados de Aluno Por Matrícula");
            System.out.println("4. Buscar Dados de Aluno(s) Por Nota");
            System.out.println("5. Ver O Tamanho da Lista");
            System.out.println("6. Imprimir Lista");
            System.out.print("9. Sair \n--->");
            // Leitura da opção escolhida pelo usuário
            int opcao = sc.nextInt();
            // Switch case para executar a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adição de um novo aluno à lista
                    int matricula1;
                    double nota;
                    System.out.println("Insira a matrícula do aluno: ");
                    matricula1 = sc.nextInt();
                    sc.nextLine(); // Consumir a nova linha pendente
                    // Solicitação da nota do aluno
                    System.out.println("Insira a nota do aluno: ");
                    // Leitura da nota do aluno como uma string e conversão para double
                    nota = Double.parseDouble(sc.nextLine());
                    // Criação de um novo objeto Aluno com os dados fornecidos
                    Aluno aluno = new Aluno(matricula1, nota);
                    // Inserção do aluno na lista de alunos
                    ListaPrincipal.insereOrdenado(aluno);
                    break;
                case 2:
                    // Remoção de um aluno da lista por matrícula
                    int matricula2;
                    System.out.println("Insira a matrícula do aluno: ");
                    matricula2 = sc.nextInt();
                    // Remoção do aluno da lista com a matrícula especificada
                    ListaPrincipal.removePorMatricula(matricula2);
                    System.out.println("Removido com sucesso.");
                    break;
                case 3:
                    // Busca de dados de um aluno por matrícula
                    System.out.println("Insira a matrícula do aluno: ");
                    int matricula3 = sc.nextInt();
                    // Busca dos dados do aluno na lista com a matrícula especificada
                    ListaPrincipal.buscaPorMatricula(matricula3);
                    break;
                case 4:
                    // Busca de dados de aluno(s) por nota
                    System.out.println("Insira a nota: ");
                    // Leitura da nota fornecida pelo usuário
                    ListaPrincipal.buscaPorNota(sc.nextDouble());
                    break;
                case 5:
                    // Verificação do tamanho da lista de alunos
                    ListaPrincipal.contaLista(ListaPrincipal);
                    break;
                case 6:
                    // Impressão da lista de alunos
                    ListaPrincipal.imprimeLista();
                    break;
                case 9:
                    // Finalização do programa
                    System.out.println("Saindo...");
                    segurador = 1;
                    break;
            }
        }
        sc.close();
    }
}
