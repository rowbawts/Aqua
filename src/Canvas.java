import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    private int playerX = 100;
    private int playerY = 100;
    private int deltaX = 0;
    private int deltaY = 0;
    
    public void movePlayer() {
        playerX += deltaX;
        playerY += deltaY;

        repaint();
    }

    public void setDelta(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50);
    }

    public Canvas() {
        setPreferredSize(new Dimension(1600, 900));
    }
}
