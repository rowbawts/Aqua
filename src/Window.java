import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("Aqua");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();

        add(canvas);
        pack();

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
