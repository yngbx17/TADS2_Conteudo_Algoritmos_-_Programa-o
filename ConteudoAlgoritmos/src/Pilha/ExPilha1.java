package Pilha;
import java.util.Scanner;

public class ExPilha1 {
	public static void main(String[] args) {
        int[] pilha = new int[10];
        int topo = -1; // Índice do topo da pilha

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 10 números:");

        for (int i = 0; i < 10; i++) {
            int numero = scanner.nextInt();
            if (numero % 2 == 0) {
                empilhar(pilha, numero, topo);
                topo++;
            } else {
                topo = desempilhar(pilha, topo);
            }
        }

        System.out.println("Elementos restantes na pilha:");
        while (topo >= 0) {
            System.out.println(pilha[topo]);
            topo--;
        }
    }

    // Função para empilhar um número na pilha
    public static void empilhar(int[] pilha, int numero, int topo) {
        if (topo < pilha.length - 1) {
            pilha[topo + 1] = numero;
        } else {
            System.out.println("A pilha está cheia!");
        }
    }

    // Função para desempilhar um número da pilha
    public static int desempilhar(int[] pilha, int topo) {
        if (topo >= 0) {
            System.out.println("Desempilhando " + pilha[topo]);
            return topo - 1;
        } else {
            System.out.println("A pilha está vazia!");
            return topo;
        }
    }
}