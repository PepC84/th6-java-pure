import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.image.BufferStrategy;

public class CustomCanvas extends Canvas {


    private static final long serialVersionUID = -912313L;

    private final int width;
    private final int height;

    public CustomCanvas(final int width, final int height) {
        this.width = width;
        this.height = height;
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(this.width, this.height));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
         addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
        });
        
        
        setFocusable(true);
        requestFocus();
    }

    public void update() {

    }

    public void draw() {
        final BufferStrategy buffer = getBufferStrategy();
        if (buffer == null) {
            createBufferStrategy(2);
            return;
        }
        

        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
        g.fillRect(5, 5, 100, 15);
        g.setColor(Color.yellow);
        g.drawString("UPS: " + '\t' + GameEngine.getUPS() + " | FPS: " + '\t'+ GameEngine.getFPS(), 6, 17);


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        buffer.show();
    }

}