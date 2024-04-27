
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
                keyBools((short)1,e.getKeyCode());

            }
            @Override
            public void keyReleased(KeyEvent e) {
                keyBools((short) 0,e.getKeyCode());
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
    public void keyBools(short k, int key){
        switch(key) {
            case KeyEvent.VK_UP:
            Main.isUp = k;
            break;
            case KeyEvent.VK_DOWN:
            Main.isDown = k;
            break;
            case KeyEvent.VK_LEFT:
            Main.isLeft = k;
            break;
            case KeyEvent.VK_RIGHT:
            Main.isLeft = k;
            break;

        }
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

        drawBackground(g);
        drawEntities(g);

        final Graphics2D j = (Graphics2D) buffer.getDrawGraphics();//yuh
        j.setColor(Color.red); //m e too!!
        j.fillRect(20,2,30,300); //check if somehting worked lawl pls delete me
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        j.dispose();
        buffer.show();
    }
    public void drawBackground(Graphics2D g) {
        g.fillRect(5, 5, 100, 15);
        g.setColor(Color.yellow);
        g.drawString("UPS: " + '\t' + GameEngine.getUPS() + " | FPS: " + '\t'+ GameEngine.getFPS(), 6, 17);


    }
    public void drawEntities(Graphics2D g) {
        
    }

}
