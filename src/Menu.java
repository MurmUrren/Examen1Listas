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

        JButton buttonInsertTail = new JButton("Insertar en Cola");
        buttonInsertTail.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Introduce el valor a insertar en la cola:");
            if (isValidNumber(dataStr)) {
                int data = Integer.parseInt(dataStr);
                linkedListGUI.insertTail(data);
            } else {
                JOptionPane.showMessageDialog(frame, "Dato introducido invalido. Porfavor introduce un entero.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertTail);

        JButton buttonInsertHead = new JButton("Insertar en Cabecera");
        buttonInsertHead.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Introduce el valor a insertar en la cabecera:");
            if (isValidNumber(dataStr)) {
                int data = Integer.parseInt(dataStr);
                linkedListGUI.insertHead(data);
            } else {
                JOptionPane.showMessageDialog(frame, "Dato introducido invalido. Porfavor introduce un entero.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertHead);

        JButton buttonInsertPosition = new JButton("Insertar en posicion");
        buttonInsertPosition.addActionListener(e -> {
            String dataStr = JOptionPane.showInputDialog(frame, "Introduce el valor a insertar:");
            String positionStr = JOptionPane.showInputDialog(frame, "Introduce la posicion donde se insertara el valor:");
            if (isValidNumber(dataStr) && isValidNumber(positionStr)) {
                int data = Integer.parseInt(dataStr);
                int position = Integer.parseInt(positionStr);
                linkedListGUI.insertOnGivenPosition(data, position);
            } else {
                JOptionPane.showMessageDialog(frame, "Valor o posicion invalido/a. Porfavor introduce enteros.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonInsertPosition);

        JButton buttonDeleteTail = new JButton("Eliminar en cola");
        buttonDeleteTail.addActionListener(e -> {
            if (!linkedListGUI.deleteTail()) {
                JOptionPane.showMessageDialog(frame, "La lista esta vacia, no hay nada que eliminar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
        controlPanel.add(buttonDeleteTail);

        JButton buttonDeleteHead = new JButton("Eliminar en cabecera");
        buttonDeleteHead.addActionListener(e -> {
            if (!linkedListGUI.deleteHead()) {
                JOptionPane.showMessageDialog(frame, "La lista esta vacia, no hay nada que eliminar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonDeleteHead);

        JButton buttonDeletePosition = new JButton("Eliminar en posicion");
        buttonDeletePosition.addActionListener(e -> {

            String positionStr = JOptionPane.showInputDialog(frame, "Introduce la posicion a eliminar:");
            if (isValidNumber(positionStr)) {
                int position = Integer.parseInt(positionStr);
                if (!linkedListGUI.deleteOnGivenPosition(position)) {
                    JOptionPane.showMessageDialog(frame, "La lista esta vacia o la posicion es invalida.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(frame, "Dato introducido invalido. Porfavor introduce un entero.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        controlPanel.add(buttonDeletePosition);

        JButton buttonClear = new JButton("Limpiar lista");
        buttonClear.addActionListener(e -> linkedListGUI.clearList());
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
