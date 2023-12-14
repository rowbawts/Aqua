import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingUtilities;

public class Launcher {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    
    public Launcher() {
        if (!gc.getImageCapabilities().isAccelerated()) {
            throw new RuntimeException("Hardware acceleration is not available.");
        }

        new Window();
    }
    
    public static void main(String[] args) throws Exception {
        System.setProperty("sun.java2d.opengl", "true");

        SwingUtilities.invokeLater(() -> new Launcher());
    }
}
