import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    
    public Main() {
        if (!gc.getImageCapabilities().isAccelerated()) {
            throw new RuntimeException("Hardware acceleration is not available.");
        }

        JFrame frame = new JFrame("Aqua");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setPreferredSize(new Dimension(1600, 900));

        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        double ellipseRadius = 600;
        double centerX = getWidth() / 2 - ellipseRadius / 2;
        double centerY = getHeight() / 2 - ellipseRadius / 2;

        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(10.0f));
        g2.draw(new Ellipse2D.Double(centerX, centerY, ellipseRadius, ellipseRadius));
    }
    
    public static void main(String[] args) throws Exception {
        System.setProperty("sun.java2d.opengl", "true");

        new Main();
    }
}
