import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("Aqua");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        InputListener inputListener = new InputListener(canvas);

        add(canvas);
        addKeyListener(inputListener);

        pack();

        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        setVisible(true);
    }
}
