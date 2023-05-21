class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
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

        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertOnGivenPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position.");
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
                System.out.println("Invalid position.");
                return;
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.getNext() == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        head = head.getNext();
    }

    public void deleteOnGivenPosition(int position) {
        if (position < 0 || head == null) {
            System.out.println("Invalid position or empty list.");
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
            System.out.println("Invalid position.");
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
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        if (current == null) {
            System.out.print("null");
        }
        System.out.println();
    }
}

