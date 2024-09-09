package Fila;
import java.util.Scanner;

	// Definição da estrutura de nó para a lista ligada (fila)
	class Node {
	    int data;
	    Node next;

	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

	// Implementação da fila dinâmica
	class Queue {
	    private Node front, rear;

	    public Queue() {
	        this.front = this.rear = null;
	    }

	    public void enqueue(int data) {
	        Node newNode = new Node(data);

	        if (isEmpty()) {
	            this.front = this.rear = newNode;
	            return;
	        }

	        this.rear.next = newNode;
	        this.rear = newNode;
	    }

	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("A fila está vazia!");
	            return -1;
	        }

	        int data = this.front.data;
	        this.front = this.front.next;

	        if (this.front == null) {
	            this.rear = null;
	        }

	        return data;
	    }

	    public boolean isEmpty() {
	        return this.front == null;
	    }
	}

	// Implementação da pilha dinâmica
	class Stack {
	    private Node top;

	    public Stack() {
	        this.top = null;
	    }

	    public void push(int data) {
	        Node newNode = new Node(data);
	        newNode.next = this.top;
	        this.top = newNode;
	    }

	    public int pop() {
	        if (isEmpty()) {
	            System.out.println("A pilha está vazia!");
	            return -1;
	        }

	        int data = this.top.data;
	        this.top = this.top.next;
	        return data;
	    }

	    public boolean isEmpty() {
	        return this.top == null;
	    }

	    // Função para mostrar os elementos da pilha
	    public void display() {
	        Node current = this.top;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}
	    public class ExFila_Pilha {
	    public static void main(String[] args) {
	        Queue fila = new Queue();
	        Stack pilha = new Stack();
	        Scanner scanner = new Scanner(System.in);

	        for (int i = 0; i < 5; i++) {
	            System.out.print("Digite um número para a fila: ");
	            int numero = scanner.nextInt();
	            fila.enqueue(numero);
	        }

	        for (int i = 0; i < 5; i++) {
	            System.out.print("Digite um número para a pilha: ");
	            int numero = scanner.nextInt();
	            pilha.push(numero);
	        }

	        int opcao;
	        do {
	            System.out.println("\nMenu de Opções:");
	            System.out.println("1 - Mostrar números que estão nas duas estruturas");
	            System.out.println("2 - Mostrar números que estão na fila");
	            System.out.println("3 - Mostrar números que estão na pilha");
	            System.out.println("4 - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    mostrarNúmerosComuns(fila, pilha);
	                    break;
	                case 2:
	                    System.out.print("Números na fila: ");
	                    mostrarFila(fila);
	                    break;
	                case 3:
	                    System.out.print("Números na pilha: ");
	                    pilha.display();
	                    break;
	                case 4:
	                    System.out.println("Saindo do programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida! Tente novamente.");
	            }
	        } while (opcao != 4);
	    }

	    // Função para mostrar os números que estão nas duas estruturas
	    public static void mostrarNúmerosComuns(Queue fila, Stack pilha) {
	        System.out.print("Números que estão nas duas estruturas: ");
	        while (!fila.isEmpty()) {
	            int numero = fila.dequeue();
	            if (buscarElemento(pilha, numero)) {
	                System.out.print(numero + " ");
	            }
	        }
	        System.out.println();
	    }

	    // Função para mostrar os números que estão na fila
	    public static void mostrarFila(Queue fila) {
	        Queue temp = new Queue();
	        while (!fila.isEmpty()) {
	            int numero = fila.dequeue();
	            System.out.print(numero + " ");
	            temp.enqueue(numero);
	        }
	        while (!temp.isEmpty()) {
	            fila.enqueue(temp.dequeue());
	        }
	        System.out.println();
	    }

	    // Função para buscar um elemento na pilha
	    public static boolean buscarElemento(Stack pilha, int elemento) {
	        Stack temp = new Stack();
	        boolean encontrado = false;
	        while (!pilha.isEmpty()) {
	            int numero = pilha.pop();
	            if (numero == elemento) {
	                encontrado = true;
	            }
	            temp.push(numero);
	        }
	        while (!temp.isEmpty()) {
	            pilha.push(temp.pop());
	        }
	        return encontrado;
	    }
	
}

