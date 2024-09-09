package Recursividade;

public class ExRecursividade2 {
	    public static void main(String[] args) {
	        contar(3);
	    }

	    public static void contar(int numero) {
	        if (numero >= 0) {
	            System.out.println(numero);
	            contar(numero - 1);
	        }
	    }
	}


