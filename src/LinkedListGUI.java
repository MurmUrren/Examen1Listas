import javax.swing.*;
import java.awt.*;

class LinkedListGUI extends JPanel {
    private final LinkedList linkedList;
    private boolean delete = false;

    public LinkedListGUI() {
        linkedList = new LinkedList();
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
    }

    public void insertTail(int data) {
        linkedList.insertTail(data);
        repaint();
    }

    public void insertHead(int data) {
        linkedList.insertHead(data);
        repaint();
    }

    public void insertOnGivenPosition(int data, int position) {
        linkedList.insertOnGivenPosition(data, position);
        repaint();
    }

    public boolean deleteTail() {
        delete = linkedList.deleteTail();
        repaint();
        return delete;
    }

    public void deleteHead() {
        linkedList.deleteHead();
        repaint();
    }

    public void deleteOnGivenPosition(int position) {
        linkedList.deleteOnGivenPosition(position);
        repaint();
    }

    public void clear() {
        linkedList.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLinkedList(g);
    }

    private void drawLinkedList(Graphics g) {
        Node current = linkedList.getHead();
        int x = 50;
        int y = 200;
        int nodeWidth = 50;
        int nodeHeight = 30;
        int arrowLength = 20;

        while (current != null) {
            // Draw rectangle representing the node
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, nodeWidth, nodeHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, nodeWidth, nodeHeight);
            g.drawString(String.valueOf(current.getData()), x + 20, y + 20);

            // Draw arrow
            if (current.getNext() != null) {
                g.drawLine(x + nodeWidth, y + nodeHeight / 2, x + nodeWidth + arrowLength, y + nodeHeight / 2);
                g.drawLine(x + nodeWidth + arrowLength, y + nodeHeight / 2, x + nodeWidth + arrowLength - 5, y + nodeHeight / 2 - 5);
                g.drawLine(x + nodeWidth + arrowLength, y + nodeHeight / 2, x + nodeWidth + arrowLength - 5, y + nodeHeight / 2 + 5);
            }

            // Update coordinates for the next node
            x += nodeWidth + arrowLength;
            current = current.getNext();
        }
    }
}

