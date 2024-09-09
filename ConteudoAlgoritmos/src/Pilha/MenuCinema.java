package Pilha;

import java.util.*;

public class MenuCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> salasCinema = new Stack<>();
        Queue<Integer> salasEspera = new LinkedList<>();

        int opcao;
        do {
            System.out.println("===== Menu Cinema =====");
            System.out.println("1. Adicionar pagantes a uma sala");
            System.out.println("2. Remover pagantes de uma sala");
            System.out.println("3. Calcular média de pagantes por sala");
            System.out.println("4. Calcular total de pagantes em todas as salas");
            System.out.println("5. Calcular valor total de ingressos vendidos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
            case 1:
                System.out.print("Informe o número da sala: ");
                int numSala = scanner.nextInt();
                System.out.print("Informe o número de pagantes: ");
                int numPagantes = scanner.nextInt();
                if (numSala > 0 && numSala <= salasCinema.size()) {
                    salasCinema.set(numSala - 1, salasCinema.get(numSala - 1) + numPagantes);
                } else {
                    System.out.println("Sala inválida. Tente novamente.");
                }
                break;

                case 2:
                    System.out.print("Informe o número da sala: ");
                    numSala = scanner.nextInt();
                    System.out.print("Informe o número de pagantes a remover: ");
                    numPagantes = scanner.nextInt();
                    if (salasCinema.size() >= numSala) {
                        int pagantesSala = salasCinema.get(numSala - 1);
                        if (pagantesSala >= numPagantes) {
                            salasCinema.set(numSala - 1, pagantesSala - numPagantes);
                        } else {
                            System.out.println("Erro: Não há pagantes suficientes na sala.");
                        }
                    } else {
                        System.out.println("Erro: Sala não encontrada.");
                    }
                    break;
                case 3:
                    if (!salasCinema.isEmpty()) {
                        int totalPagantes = 0;
                        for (int pagantes : salasCinema) {
                            totalPagantes += pagantes;
                        }
                        double mediaPagantes = (double) totalPagantes / salasCinema.size();
                        System.out.println("Média de pagantes por sala: " + mediaPagantes);
                    } else {
                        System.out.println("Não há salas cadastradas.");
                    }
                    break;
                case 4:
                    int totalPagantes = 0;
                    for (int pagantes : salasCinema) {
                        totalPagantes += pagantes;
                    }
                    System.out.println("Total de pagantes em todas as salas: " + totalPagantes);
                    break;
                case 5:
                    int valorTotalIngressos = 30 * salasCinema.size();
                    System.out.println("Valor total de ingressos vendidos: R$" + valorTotalIngressos);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
