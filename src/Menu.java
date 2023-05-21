import javax.swing.*;
import java.awt.*;


public class Menu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Linked List GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 400);

        LinkedListGUI linkedListGUI = new LinkedListGUI();

        JPanel controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(800, 100));
        controlPanel.setBackground(Color.LIGHT_GRAY);

        JButton buttonInsertTail = new JButton("Insert Tail");
        buttonInsertTail.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Enter data to insert at tail:");
            if (isValidNumber(dataStr)) {
                int data = Integer.parseInt(dataStr);
                linkedListGUI.insertTail(data);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid data input. Please enter an integer.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertTail);

        JButton buttonInsertHead = new JButton("Insert Head");
        buttonInsertHead.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Enter data to insert at head:");
            if (isValidNumber(dataStr)) {
                int data = Integer.parseInt(dataStr);
                linkedListGUI.insertHead(data);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid data input. Please enter an integer.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertHead);

        JButton buttonInsertPosition = new JButton("Insert at Position");
        buttonInsertPosition.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Enter data to insert:");
            String positionStr = JOptionPane.showInputDialog(frame, "Enter position to insert at:");
            if (isValidNumber(dataStr) && isValidNumber(positionStr)) {
                int data = Integer.parseInt(dataStr);
                int position = Integer.parseInt(positionStr);
                linkedListGUI.insertOnGivenPosition(data, position);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid data or position input. Please enter integers.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertPosition);

        JButton buttonDeleteTail = new JButton("Delete Tail");
        buttonDeleteTail.addActionListener(e -> {
            if (!linkedListGUI.deleteTail()) {
                JOptionPane.showMessageDialog(frame, "La lista esta vacia, no hay nada que eliminar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
        controlPanel.add(buttonDeleteTail);

        JButton buttonDeleteHead = new JButton("Delete Head");
        buttonDeleteHead.addActionListener(e -> linkedListGUI.deleteHead());
        controlPanel.add(buttonDeleteHead);

        JButton buttonDeletePosition = new JButton("Delete at Position");
        buttonDeletePosition.addActionListener(e -> {
            String positionStr = JOptionPane.showInputDialog(frame, "Enter position to delete:");
            if (isValidNumber(positionStr)) {
                int position = Integer.parseInt(positionStr);
                linkedListGUI.deleteOnGivenPosition(position);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid position input. Please enter an integer.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonDeletePosition);

        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener(e -> linkedListGUI.clear());
        controlPanel.add(buttonClear);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
        frame.getContentPane().add(linkedListGUI, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static boolean isValidNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
