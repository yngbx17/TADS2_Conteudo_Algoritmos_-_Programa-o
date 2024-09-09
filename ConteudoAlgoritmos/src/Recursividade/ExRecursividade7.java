package Recursividade;
import java.util.Scanner;

public class ExRecursividade7 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("\nDigite um número entre 1 e 3");
	        int a = scanner.nextInt();
	        validarNumero(a);
	        scanner.close();
	    }

	    public static void validarNumero(int a) {
	        if (a < 1 || a > 3) {
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("\nErrrrou! Tente novamente!");
	            a = scanner.nextInt();
	            validarNumero(a); // Chamada recursiva
	            scanner.close();
	        } else {
	            System.out.println("Tchau");
	        }
	    }
	}


