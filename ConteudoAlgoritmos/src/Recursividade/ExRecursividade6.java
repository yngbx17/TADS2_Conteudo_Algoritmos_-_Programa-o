package Recursividade;
import java.util.Scanner;

public class ExRecursividade6 {
	    public static void main(String[] args) {
	        menu();
	    }

	    public static void menu() {
	        Scanner scanner = new Scanner(System.in);
	        int a;
	        
	        System.out.println("\nMenu:");
	        System.out.println("1-Dizer oi");
	        a = scanner.nextInt();
	        
	        if (a != 1) {
	            menu();  // Chamada recursiva se a for diferente de 1
	        } else {
	            System.out.println("\nOi");
	        }
	        
	        scanner.close();
	    }
	}


