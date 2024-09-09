package PesquisaSequencialBinaria;
import java.util.Scanner;
public class ExSequencia2 {

	    
	    // Função para realizar a busca binária
	    public static int buscaBinaria(int[] vetor, int elemento) {
	        int inicio = 0;
	        int fim = vetor.length - 1;
	        int iteracao = 1;
	        
	        while (inicio <= fim) {
	            int meio = (inicio + fim) / 2;
	            
	            if (vetor[meio] == elemento)
	                return meio;
	            else if (vetor[meio] < elemento) {
	                System.out.println(iteracao + "ª iteração: " + (meio - inicio + 1) + " elementos descartados à esquerda.");
	                inicio = meio + 1;
	            } else {
	                System.out.println(iteracao + "ª iteração: " + (fim - meio + 1) + " elementos descartados à direita.");
	                fim = meio - 1;
	            }
	            
	            iteracao++;
	        }
	        
	        return -1; // Se o elemento não for encontrado
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Digite a quantidade de elementos do vetor: ");
	        int tamanho = scanner.nextInt();
	        
	        int[] vetor = new int[tamanho];
	        
	        System.out.print("Digite os elementos do vetor: ");
	        for (int i = 0; i < tamanho; i++) {
	            vetor[i] = scanner.nextInt();
	        }
	        
	        System.out.print("Digite o elemento procurado: ");
	        int elementoProcurado = scanner.nextInt();
	        
	        int posicao = buscaBinaria(vetor, elementoProcurado);
	        
	        if (posicao != -1) {
	            System.out.println("Posição do elemento procurado: " + posicao);
	        } else {
	            System.out.println("Elemento não encontrado.");
	        }
	        
	        scanner.close();
	    }
	}


