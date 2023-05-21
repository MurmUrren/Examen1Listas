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

    public void deleteHead() {
        if (head == null) {
            System.out.println("La lista esta vacia, no hay nada que eliminar.");
            return;
        }

        head = head.getNext();
    }

    public void deleteOnGivenPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Posicion invalida o lista vacia");
            return;
        }

        if (position == 1) {
            head = head.getNext();
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        if (current == null || current.getNext() == null) {
            System.out.println("Posicion invalida.");
            return;
        }

        current.setNext(current.getNext().getNext());
    }

    public void clear() {
        head = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


}
