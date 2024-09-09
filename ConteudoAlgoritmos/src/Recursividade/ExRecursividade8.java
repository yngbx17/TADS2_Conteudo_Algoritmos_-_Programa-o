package Recursividade;

public class ExRecursividade8 {
	    public static void main(String[] args) {
	        exibirNumeros(0);
	    }

	    public static void exibirNumeros(int i) {
	        if (i < 4) {
	            System.out.println("\nE dá-lhe " + i);
	            exibirNumeros(i + 1); // Chamada recursiva
	        }
	    }
	}


