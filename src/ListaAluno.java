/*
 * KAUÊ DE SOUZA ROSA - ESTRUTURA DE DADOS 1 - 09/03/2024
 * 
 *  A seguinte classe ListaAluno é responsável por gerenciar uma lista encadeada de alunos, oferecendo funcionalidades como armazenamento,
 * ordenação por nota, manipulação de alunos e controle do tamanho da lista. 
 *  Seus principais objetivos incluem armazenar e organizar os dados dos alunos,
 * permitindo operações como adição, remoção e busca.
 */


public class ListaAluno {
    // Classe interna Celula que representa os nós individuais da lista encadeada
    private static class Celula {
        Aluno aluno; // Referência para um objeto Aluno
        Celula prox; // Referência para a próxima célula na lista
    }

    // Atributos da classe ListaAluno
    private Celula primeiro; // Referência para o primeiro nó da lista
    private Celula ultimo; // Referência para o último nó da lista
    private Celula pos; // Referência para uma posição atual na lista

    // Métodos para definir e obter o primeiro nó da lista
    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public Celula getPrimeiro() {
        return primeiro;
    }

    // Métodos para definir e obter o último nó da lista
    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }

    public Celula getUltimo() {
        return ultimo;
    }

    // Métodos para definir e obter a posição atual na lista
    public void setPos(Celula pos) {
        this.pos = pos;
    }

    public Celula getPos() {
        return pos;
    }

    // Construtor da classe ListaAluno
    public ListaAluno() {
        primeiro = new Celula(); // Criação do primeiro nó vazio
        ultimo = primeiro; // O último nó também é o primeiro inicialmente
        primeiro.prox = null; // Inicializa a referência para o próximo nó como nula
    }

    // Método para inserir um novo aluno no início da lista
    public void insereInicio(Aluno x) {
        Celula novo = new Celula(); // Criação de uma nova célula
        novo.aluno = x; // Atribuição do aluno à célula
        novo.prox = primeiro.prox; // O próximo da nova célula é o antigo primeiro
        primeiro.prox = novo; // O próximo do primeiro é a nova célula
        if (ultimo == primeiro) { // Se a lista estava vazia, atualiza o último nó
            ultimo = novo;
        }
    }

    // Método para imprimir os dados de todos os alunos na lista
    public void imprimeLista() {
        Celula atual = primeiro.prox; // Começa a partir do primeiro nó real
        int i = 1;
        System.out.println("\nLista de Alunos: ");
        while (atual != null) { // Percorre a lista enquanto houver nós
            System.out.print("Aluno " + i + ",");
            System.out.print(" Matrícula: " + atual.aluno.getMatricula()+",");
            System.out.print(" Nota: " + atual.aluno.getNota());
            System.out.println("\n");
            atual = atual.prox; // Move para o próximo nó
            i++;
        }
    }

    // Método para imprimir os dados de alunos a partir de uma posição específica
    public void imprimeListaAlt(int i) {
        Celula atual = primeiro.prox; // Começa a partir do primeiro nó real
        while (atual != null) { // Percorre a lista enquanto houver nós
            System.out.println("Aluno " + i + ":");
            System.out.println("Nota: " + atual.aluno.getNota());
            System.out.println("Matrícula: " + atual.aluno.getMatricula());
            System.out.println("\n");
            atual = atual.prox; // Move para o próximo nó
            i++;
        }
    }

    // Método para inserir um novo aluno na lista de forma ordenada pela nota
    public void insereOrdenado(Aluno novoAluno) {
        Celula novaCelula = new Celula(); // Cria uma nova célula para o novo aluno
        novaCelula.aluno = novoAluno; // Atribui o aluno à nova célula

        Celula atual = primeiro;
        // Encontra o local correto na lista onde o novo aluno deve ser inserido
        while (atual.prox != null && atual.prox.aluno.getNota() < novoAluno.getNota()) {
            atual = atual.prox;
        }

        // Insere a nova célula na posição correta
        Celula proximaCelula = atual.prox;
        atual.prox = novaCelula;
        novaCelula.prox = proximaCelula;

        // Atualiza o último nó, se necessário
        if (atual == ultimo) {
            ultimo = novaCelula;
        }
    }

    // Método para contar o número de alunos na lista
    public int contaLista(ListaAluno lista) {
        int cont = 0;
        Celula atual = lista.primeiro.prox;
        while (atual != null) { // Percorre a lista enquanto houver nós
            cont = cont + 1; // Incrementa o contador
            atual = atual.prox; // Move para o próximo nó
        }
        System.out.println("Tamanho da Lista: ");
        System.out.println(cont);
        System.out.println("\n");
        return cont; // Retorna o número total de alunos na lista
    }

    // Método para remover um aluno da lista com base na matrícula
    public Aluno removePorMatricula(int matricula) throws Exception {
        Celula aux = primeiro;
        while (aux.prox != null && aux.prox.aluno.getMatricula() != matricula)
            aux = aux.prox;

        if (aux.prox == null)
            return null; // Matrícula não encontrada

        // Salva a célula encontrada
        Celula q = aux.prox;
        // Salva o aluno encontrado
        Aluno alunoEncontrado = q.aluno;
        // Remove a célula da lista
        aux.prox = q.prox;

        // Atualiza o último nó, se necessário
        if (aux.prox == null)
            ultimo = aux;

        return alunoEncontrado; // Retorna o aluno removido
    }

   // Método para buscar um aluno na lista com base na matrícula
public void buscaPorMatricula(int matricula) throws Exception {
    Celula aux = primeiro;
    int i = 0;
    while (aux.prox != null && aux.prox.aluno.getMatricula() != matricula) {
        aux = aux.prox;
        i++;
    }

    if (aux.prox == null)
        return;

    Celula q = aux.prox;
    Aluno alunoEncontrado = q.aluno;
    System.out.println("Aluno " + i + ": ");
    System.out.println("Nota: " + alunoEncontrado.getNota());
    System.out.println("Matrícula: " + alunoEncontrado.getMatricula());
    System.out.println("\n");
}
    // Método para buscar alunos na lista com base na nota
    public void buscaPorNota(double nota) throws Exception {
        Celula aux = primeiro.prox;
        ListaAluno listaN = new ListaAluno();
        int i = 0;
        int inicio = 0;

        // Percorre a lista para encontrar o último elemento
        while (aux != null) {
            // Verifica se a nota do aluno atual coincide com a nota fornecida
            if (aux.aluno.getNota() == nota) {
                // Se uma correspondência for encontrada, insere o índice do aluno na lista
                // secundária
                listaN.insereInicio(aux.aluno);
                if (inicio == 0) {
                    inicio = i;
                }
            }
            // Move para o próximo elemento da lista
            aux = aux.prox;
            i++;
        }

        // Imprime os alunos da lista secundária de acordo com a ordem de suas posições
        // na lista principal
        listaN.imprimeListaAlt(inicio);
    }
}
