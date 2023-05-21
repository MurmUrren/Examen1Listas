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
        System.out.println("=== Linked List Program ===");
        System.out.println("1. Insert Node on Head");
        System.out.println("2. Insert Node on Tail");
        System.out.println("3. Insert Node on Given Position");
        System.out.println("4. Delete Head Node");
        System.out.println("5. Delete Tail Node");
        System.out.println("6. Delete Node on Given Position");
        System.out.println("7. Display Linked List");
        System.out.println("8. Clear Linked List");
        System.out.println("0. Exit");
        System.out.println("==========================");
    }

    public void run() {
        int option = -1;

        while (option != 0) {
            showMenu();
            System.out.print("Enter your choice: ");
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
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private void insertNodeOnHead() {
        System.out.print("Enter the data for the new node: ");
        int data;
        try {
            data = scanner.nextInt();
            linkedList.insertHead(data);
            System.out.println("Node inserted at the head.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    private void insertNodeOnTail() {
        System.out.print("Enter the data for the new node: ");
        int data;
        try {
            data = scanner.nextInt();
            linkedList.insertTail(data);
            System.out.println("Node inserted at the tail.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    private void insertNodeOnGivenPosition() {
        System.out.print("Enter the data for the new node: ");
        int data;
        try {
            data = scanner.nextInt();
            System.out.print("Enter the position to insert the node: ");
            int position = scanner.nextInt();
            linkedList.insertOnGivenPosition(data, position);
            //System.out.println("Node inserted at position " + position + ".");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers for data and position.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    private void deleteHeadNode() {
        linkedList.deleteHead();
        System.out.println("Head node deleted.");
    }

    private void deleteTailNode() {
        linkedList.deleteTail();
        System.out.println("Tail node deleted.");
    }

    private void deleteNodeOnGivenPosition() {
        System.out.print("Enter the position of the node to delete: ");
        int position = scanner.nextInt();
        linkedList.deleteOnGivenPosition(position);
        System.out.println("Node at position " + position + " deleted.");
    }

    private void displayLinkedList() {
        System.out.print("Linked List: ");
        linkedList.display();
    }

    private void clearLinkedList() {
        linkedList.clear();
        System.out.println("Linked List cleared.");
    }
}