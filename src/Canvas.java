import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        double ellipseRadius = 600;
        double centerX = getWidth() / 2 - ellipseRadius / 2;
        double centerY = getHeight() / 2 - ellipseRadius / 2;

        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(10.0f));
        g2.draw(new Ellipse2D.Double(centerX, centerY, ellipseRadius, ellipseRadius));
    }

    public Canvas() {
        setPreferredSize(new Dimension(1600, 900));
    }
}
