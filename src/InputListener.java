import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class InputListener implements KeyListener {
    private Canvas canvas;
    private Timer timer;

    private int moveSpeed = 1;

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public InputListener(Canvas canvas) {
        this.canvas = canvas;
        
        this.timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleKeyPress();
            }
        });
        this.timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        handleKey(e.getKeyCode(), true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handleKey(e.getKeyCode(), false);
    }

    private void handleKey(int keyCode, boolean pressed) {
        // Update the pressed state of each key
        switch (keyCode) {
            case KeyEvent.VK_W:
                upPressed = pressed;
                break;
            case KeyEvent.VK_S:
                downPressed = pressed;
                break;
            case KeyEvent.VK_A:
                leftPressed = pressed;
                break;
            case KeyEvent.VK_D:
                rightPressed = pressed;
                break;
        }

        // Update delta values based on the combination of pressed keys
        int deltaX = (rightPressed ? moveSpeed : 0) - (leftPressed ? moveSpeed : 0);
        int deltaY = (downPressed ? moveSpeed : 0) - (upPressed ? moveSpeed : 0);

        canvas.setDelta(deltaX, deltaY);
    }

    private void handleKeyPress() {
        // Handle continuous movement
        canvas.movePlayer();
    }
}
