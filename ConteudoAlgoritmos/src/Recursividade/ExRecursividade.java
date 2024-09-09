package Recursividade;

public class ExRecursividade {
	    public static void main(String[] args) {
	        contar(1);
	    }

	    public static void contar(int numero) {
	        if (numero <= 3) {
	            System.out.println(numero);
	            contar(numero + 1);
	        }
	    }
	}


