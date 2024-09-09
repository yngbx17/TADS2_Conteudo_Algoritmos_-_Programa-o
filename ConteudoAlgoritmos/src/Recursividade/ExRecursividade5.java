package Recursividade;
import java.util.Scanner;

public class ExRecursividade5 {
	    public static void main(String[] args) {
	        menu();
	    }

	    public static void menu() {
	        Scanner scanner = new Scanner(System.in);
	        int a;
	        
	        System.out.println("\nMenu:");
	        System.out.println("1-Dizer oi");
	        System.out.println("Outro número para sair");
	        a = scanner.nextInt();
	        
	        if (a == 1) {
	            System.out.println("\nOi");
	            menu();  // Chamada recursiva se a for igual a 1
	        }
	        
	        scanner.close();
	    }
	}


