package Fila;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Aluno {
    private int numero;
    private String nome;

    public Aluno(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
}

class Nota {
    private int numeroAluno;
    private double valor;

    public Nota(int numeroAluno, double valor) {
        this.numeroAluno = numeroAluno;
        this.valor = valor;
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public double getValor() {
        return valor;
    }
}

public class SistemaNotas {
    private Stack<Aluno> alunos;
    private Queue<Nota> notas;

    public SistemaNotas() {
        alunos = new Stack<>();
        notas = new LinkedList<>();
    }

    public void cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(alunos.size() + 1, nome);
        alunos.push(aluno);
    }

    public void cadastrarNota(int numeroAluno, double nota) {
        boolean alunoEncontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNumero() == numeroAluno) {
                alunoEncontrado = true;
                notas.add(new Nota(numeroAluno, nota));
                break;
            }
        }
        if (!alunoEncontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void calcularMedia(int numeroAluno) {
        double soma = 0;
        int contador = 0;
        for (Nota nota : notas) {
            if (nota.getNumeroAluno() == numeroAluno) {
                soma += nota.getValor();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Aluno não possui notas cadastradas.");
        } else {
            double media = soma / contador;
            System.out.println("Média do aluno: " + media);
        }
    }

    public void listarAlunosSemNotas() {
        boolean temAlunoSemNota = false;
        for (Aluno aluno : alunos) {
            boolean alunoTemNota = false;
            for (Nota nota : notas) {
                if (nota.getNumeroAluno() == aluno.getNumero()) {
                    alunoTemNota = true;
                    break;
                }
            }
            if (!alunoTemNota) {
                System.out.println("Aluno sem notas: " + aluno.getNome());
                temAlunoSemNota = true;
            }
        }
        if (!temAlunoSemNota) {
            System.out.println("Todos os alunos possuem notas cadastradas.");
        }
    }

    public void excluirAluno() {
        if (!notas.isEmpty()) {
            System.out.println("Não é possível excluir aluno com notas cadastradas.");
            return;
        }

        if (!alunos.isEmpty()) {
            Aluno alunoRemovido = alunos.pop();
            System.out.println("Aluno removido: " + alunoRemovido.getNome());
        } else {
            System.out.println("Não há alunos cadastrados para excluir.");
        }
    }

    public void excluirNota() {
        if (!notas.isEmpty()) {
            Nota notaRemovida = notas.poll();
            System.out.println("Nota removida do aluno " + notaRemovida.getNumeroAluno());
        } else {
            System.out.println("Não há notas cadastradas para excluir.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaNotas sistema = new SistemaNotas();

        int opcao;
        do {
            System.out.println("Menu de Opções:");
            System.out.println("1 – Cadastrar aluno");
            System.out.println("2 – Cadastrar nota");
            System.out.println("3 – Calcular a média de um aluno");
            System.out.println("4 – Listar os nomes dos alunos sem notas");
            System.out.println("5 – Excluir aluno");
            System.out.println("6 – Excluir nota");
            System.out.println("7 – Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    scanner.nextLine(); // limpar o buffer do scanner
                    String nomeAluno = scanner.nextLine();
                    sistema.cadastrarAluno(nomeAluno);
                    break;
                case 2:
                    System.out.print("Digite o número do aluno: ");
                    int numeroAluno = scanner.nextInt();
                    System.out.print("Digite a nota: ");
                    double nota = scanner.nextDouble();
                    sistema.cadastrarNota(numeroAluno, nota);
                    break;
                case 3:
                    System.out.print("Digite o número do aluno: ");
                    int numAlunoMedia = scanner.nextInt();
                    sistema.calcularMedia(numAlunoMedia);
                    break;
                case 4:
                    sistema.listarAlunosSemNotas();
                    break;
                case 5:
                    sistema.excluirAluno();
                    break;
                case 6:
                    sistema.excluirNota();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
