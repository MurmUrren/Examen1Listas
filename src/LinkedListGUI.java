import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LinkedListGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textFieldData;
    private JTextField textFieldPosition;
    private JButton buttonInsertTail;
    private JButton buttonInsertHead;
    private JButton buttonInsertPosition;
    private JButton buttonDeleteTail;
    private JButton buttonDeleteHead;
    private JButton buttonDeletePosition;
    private JButton buttonClear;

    private LinkedList linkedList;

    public LinkedListGUI() {
        linkedList = new LinkedList();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Linked List Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 400);
        frame.getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 370, 200);
        frame.getContentPane().add(scrollPane);

        JLabel lblData = new JLabel("Data:");
        lblData.setBounds(10, 220, 70, 20);
        frame.getContentPane().add(lblData);

        textFieldData = new JTextField();
        textFieldData.setBounds(90, 220, 100, 20);
        frame.getContentPane().add(textFieldData);
        textFieldData.setColumns(10);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(200, 220, 70, 20);
        frame.getContentPane().add(lblPosition);

        textFieldPosition = new JTextField();
        textFieldPosition.setBounds(280, 220, 100, 20);
        frame.getContentPane().add(textFieldPosition);
        textFieldPosition.setColumns(10);

        buttonInsertTail = new JButton("Insert Tail");
        buttonInsertTail.setBounds(10, 250, 100, 30);
        frame.getContentPane().add(buttonInsertTail);

        buttonInsertHead = new JButton("Insert Head");
        buttonInsertHead.setBounds(120, 250, 100, 30);
        frame.getContentPane().add(buttonInsertHead);

        buttonInsertPosition = new JButton("Insert Position");
        buttonInsertPosition.setBounds(230, 250, 150, 30);
        frame.getContentPane().add(buttonInsertPosition);

        buttonDeleteTail = new JButton("Delete Tail");
        buttonDeleteTail.setBounds(10, 290, 100, 30);
        frame.getContentPane().add(buttonDeleteTail);

        buttonDeleteHead = new JButton("Delete Head");
        buttonDeleteHead.setBounds(120, 290, 100, 30);
        frame.getContentPane().add(buttonDeleteHead);

        buttonDeletePosition = new JButton("Delete Position");
        buttonDeletePosition.setBounds(230, 290, 150, 30);
        frame.getContentPane().add(buttonDeletePosition);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(10, 330, 100, 30);
        frame.getContentPane().add(buttonClear);

        buttonInsertTail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertTail();
            }
        });

        buttonInsertHead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertHead();
            }
        });

        buttonInsertPosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertOnGivenPosition();
            }
        });

        buttonDeleteTail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTail();
            }
        });

        buttonDeleteHead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteHead();
            }
        });

        buttonDeletePosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteOnGivenPosition();
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        frame.setVisible(true);
    }

    private void insertTail() {
        String dataStr = textFieldData.getText();
        if (isValidNumber(dataStr)) {
            int data = Integer.parseInt(dataStr);
            linkedList.insertTail(data);
            displayLinkedList();
            textFieldData.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "El dato introducido es invalido. Porfavor ingresa un entero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertHead() {
        String dataStr = textFieldData.getText();
        if (isValidNumber(dataStr)) {
            int data = Integer.parseInt(dataStr);
            linkedList.insertHead(data);
            displayLinkedList();
            textFieldData.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "El dato introducido es invalido. Porfavor ingresa un entero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertOnGivenPosition() {
        String dataStr = textFieldData.getText();
        String positionStr = textFieldPosition.getText();

        if (isValidNumber(dataStr) && isValidNumber(positionStr)) {
            int data = Integer.parseInt(dataStr);
            int position = Integer.parseInt(positionStr);
            linkedList.insertOnGivenPosition(data, position);
            displayLinkedList();
            textFieldData.setText("");
            textFieldPosition.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "El dato o posicion introducida es invalido/a. Porfavor ingresa enteros.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTail() {
        linkedList.deleteTail();
        displayLinkedList();
    }

    private void deleteHead() {
        linkedList.deleteHead();
        displayLinkedList();
    }

    private void deleteOnGivenPosition() {
        String positionStr = textFieldPosition.getText();

        if (isValidNumber(positionStr)) {
            int position = Integer.parseInt(positionStr);
            linkedList.deleteOnGivenPosition(position);
            displayLinkedList();
            textFieldPosition.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "La posicion ingresada es invalida. Porfavor ingresa enteros.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clear() {
        linkedList.clear();
        displayLinkedList();
    }

    private void displayLinkedList() {
        StringBuilder sb = new StringBuilder();
        Node current = linkedList.head;
        while (current != null) {
            sb.append(current.getData()).append("->");
            current = current.getNext();
        }
        if (current == null) {
            sb.append("null");
        }
        textArea.setText(sb.toString());
    }

    private boolean isValidNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
