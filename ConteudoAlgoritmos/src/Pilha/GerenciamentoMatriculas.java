package Pilha;

import java.util.*;

class Aluno {
    private String nome;
    private int matricula;
    private List<String> disciplinasMatriculadas;
    private Stack<String> historicoDisciplinasCursadas;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.disciplinasMatriculadas = new ArrayList<>();
        this.historicoDisciplinasCursadas = new Stack<>();
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinasMatriculadas.add(disciplina);
    }

    public void removerDisciplina(String disciplina) {
        this.disciplinasMatriculadas.remove(disciplina);
    }

    public void adicionarHistoricoDisciplina(String disciplina) {
        this.historicoDisciplinasCursadas.push(disciplina);
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Disciplinas Matriculadas: " + this.disciplinasMatriculadas);
        System.out.println("Histórico de Disciplinas Cursadas: " + this.historicoDisciplinasCursadas);
    }
}

class Disciplina {
    private String nome;
    private int vagasDisponiveis;
    private Queue<Aluno> filaEspera;

    public Disciplina(String nome, int vagasDisponiveis) {
        this.nome = nome;
        this.vagasDisponiveis = vagasDisponiveis;
        this.filaEspera = new LinkedList<>();
    }

    public void adicionarAlunoFilaEspera(Aluno aluno) {
        this.filaEspera.add(aluno);
    }

    public void matricularAluno(Aluno aluno) {
        if (this.vagasDisponiveis > 0) {
            aluno.adicionarDisciplina(this.nome);
            aluno.adicionarHistoricoDisciplina(this.nome);
            this.vagasDisponiveis--;
        } else {
            System.out.println("Não há vagas disponíveis. Adicionando aluno à lista de espera.");
            adicionarAlunoFilaEspera(aluno);
        }
    }

    public void exibirFilaEspera() {
        System.out.println("Fila de Espera para " + this.nome + ": " + this.filaEspera);
    }
}

public class GerenciamentoMatriculas {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João", 123);
        Aluno aluno2 = new Aluno("Maria", 456);

        Disciplina disciplina = new Disciplina("Programação Java", 2);
        disciplina.matricularAluno(aluno1);
        disciplina.matricularAluno(aluno2);

        disciplina.exibirFilaEspera();

        aluno1.exibirInformacoes();
        aluno2.exibirInformacoes();
    }
}
