class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return this.head;
    }

    public void insertTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void insertHead(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void insertOnGivenPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Posicion invalida.");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            int currentPosition = 1;

            while (current != null && currentPosition < position - 1) {
                current = current.getNext();
                currentPosition++;
            }

            if (current == null) {
                System.out.println("Posicion invalida.");
                return;
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public boolean deleteTail() {
        if (head == null) {
            System.out.println("La lista esta vacia, no hay nada que eliminar.");
            return false;
        }

        if (head.getNext() == null) {
            head = null;
            return true;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        return true;
    }

    public boolean deleteHead() {
        if (head == null) {
            System.out.println("La lista esta vacia, no hay nada que eliminar.");
            return false;
        }

        head = head.getNext();
        return true;
    }

    public boolean deleteOnGivenPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Posicion invalida o lista vacia");
            return false;
        }

        if (position == 1) {
            head = head.getNext();
            return true;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        if (current == null || current.getNext() == null) {
            System.out.println("Posicion invalida.");
            return false;
        }

        current.setNext(current.getNext().getNext());
        return true;
    }

    public void clearList() {
        head = null;
    }


}
