import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LinkedListGUI::new);
    }

   /*
   Aqui la IDE me marcaba Warnings en Java, diciendo que podia implementar lambdas y si le daba a implementar solito lo hacia
   Realmente no soy muy bueno en lambdas asi que aqui dejare comentado lo que yo habia hecho:

    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LinkedListGUI();
            }
        });
     */

}
