import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    private final LinkedList linkedList;
    private final Scanner scanner;

    public Menu() {
        this.linkedList = new LinkedList();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("=== Programa Linked List ===");
        System.out.println("1. Insertar nodo en la cabecera");
        System.out.println("2. Insertar nodo en la cola);
        System.out.println("3. Insertar nodo en x posicion");
        System.out.println("4. Eliminar nodo de la cabecera");
        System.out.println("5. Eliminar nodo de la cola");
        System.out.println("6. Eliminar nodo en x posicion");
        System.out.println("7. Mostrar Linked List");
        System.out.println("8. Limpiar Linked List");
        System.out.println("0. Salir");
        System.out.println("==========================");
    }

    public void run() {
        int option = -1;

        while (option != 0) {
            showMenu();
            System.out.print("Ingresa la opcion deseada: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> insertNodeOnHead();
                case 2 -> insertNodeOnTail();
                case 3 -> insertNodeOnGivenPosition();
                case 4 -> deleteHeadNode();
                case 5 -> deleteTailNode();
                case 6 -> deleteNodeOnGivenPosition();
                case 7 -> displayLinkedList();
                case 8 -> clearLinkedList();
                case 0 -> System.out.println("Finalizando programa");
                default -> System.out.println("Opcion invalida.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private void insertNodeOnHead() {
        System.out.print("Ingresa el valor a agregar en el nuevo nodo: ");
        int data;
        try {
            data = scanner.nextInt();
            linkedList.insertHead(data);
            System.out.println("Node inserted at the head.");
        } catch (InputMismatchException e) {
            System.out.println("El dato introducido es invalido. Porfavor introduce un entero.");
            scanner.nextLine();
        }
    }

    private void insertNodeOnTail() {
        System.out.print("Ingresa el valor a agregar en el nuevo nodo: ");
        int data;
        try {
            data = scanner.nextInt();
            linkedList.insertTail(data);
            System.out.println("Nodo insertado en la cola.");
        } catch (InputMismatchException e) {
            System.out.println("El dato introducido es invalido. Porfavor introduce un entero.");
            scanner.nextLine(); 
        }
    }

    private void insertNodeOnGivenPosition() {
        System.out.print("Ingresa el valor a agregar en el nuevo nodo: ");
        int data;
        try {
            data = scanner.nextInt();
            System.out.print("Ingresa la posicion en donde se agregara el nodo: ");
            int position = scanner.nextInt();
            linkedList.insertOnGivenPosition(data, position);
        } catch (InputMismatchException e) {
            System.out.println("El dato introducido es invalido. Porfavor introduce un entero.");
            scanner.nextLine(); 
        }
    }

    private void deleteHeadNode() {
        linkedList.deleteHead();
        System.out.println("Nodo cabecera eliminado.");
    }

    private void deleteTailNode() {
        linkedList.deleteTail();
        System.out.println("Nodo cola eliminado.");
    }

    private void deleteNodeOnGivenPosition() {
        System.out.print("Ingresa la posicion del nodo a eliminar: ");
        int position = scanner.nextInt();
        linkedList.deleteOnGivenPosition(position);
        System.out.println("Nodo en la posicion " + position + " eliminado.");
    }

    private void displayLinkedList() {
        System.out.print("Linked List: ");
        linkedList.display();
    }

    private void clearLinkedList() {
        linkedList.clear();
        System.out.println("Se limpio la Linked List.");
    }
}
