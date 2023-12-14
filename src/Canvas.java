import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    private int playerX = 100;
    private int playerY = 100;
    private int deltaX = 0;

    private float gravity = 0.5f;
    private float playerVelocityY = 0;

    boolean isJumping = false;
    
    public void movePlayer() {
        playerVelocityY += gravity; // Apply gravity
        playerY += playerVelocityY;

        // Collision with the ground (adjust this condition based on your game)
        if (playerY >= getHeight() - 100) {
            playerY = getHeight() - 100;
            playerVelocityY = 0;
            isJumping = false;
        }

        playerX += deltaX;

        repaint();
    }

    public void jump() {
        playerVelocityY = -10.0f;
        isJumping = true;
    }

    public void setDelta(int deltaX) {
        this.deltaX = deltaX;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the floor
        g.setColor(Color.RED);
        g.fillRect(0, getHeight() - 50, getWidth(), 50);

        // Draw the player
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50);
    }

    public Canvas() {
        setPreferredSize(new Dimension(1600, 900));
    }
}
