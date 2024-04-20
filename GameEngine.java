import javax.swing.*;
import java.awt.*;

public class GameEngine extends JFrame {
    private boolean running = false;
    private final String title;
    private final int width;
    private final int height;

    public static CustomCanvas cc;

    private static int UPS_TARGET = 60;
    private static int FPS_TARGET = 60;
    private static int fps = 0;
    private static int ups = 0; //updatespersecond



    public GameEngine(final String title, final int width, final int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        setTitle(this.title);
        cc = new CustomCanvas(this.width, this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        add(cc, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startGame() {
        initiate();
        running = true;
    }

    private void initiate() {
        
    }

    public void startMainLoop() {
        int accumulatedUpdates = 0;
        int accumulatedFrames = 0;

        final int NS_PER_SECOND = 1000000000; // billion <-> mil millones
        final double TIME_PER_UPDATE = NS_PER_SECOND / UPS_TARGET;
        final double TIME_PER_RENDER = NS_PER_SECOND / FPS_TARGET;

        long lastUpdate = System.nanoTime();
        long lastCounter = System.nanoTime();

        double currentTime;
        double deltaAps = 0;
        double deltaFps = 0;

        while (running) {
            final long beginLoop = System.nanoTime();

            currentTime = beginLoop - lastUpdate;
            lastUpdate = beginLoop;

            deltaAps += currentTime / TIME_PER_UPDATE;

            while (deltaAps >= 1) {
                update();
                accumulatedUpdates++;
                deltaAps--;
            }

            deltaFps += currentTime / TIME_PER_RENDER;

            if (deltaFps >= 1) {
                draw();
                accumulatedFrames++;
                deltaFps = 0;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (System.nanoTime() - lastCounter > NS_PER_SECOND) {

                ups = accumulatedUpdates;
                fps = accumulatedFrames;

                accumulatedUpdates = 0;
                accumulatedFrames = 0;
                lastCounter = System.nanoTime();
            }
        }
    }

    private void update() {
                // Lógica del juego, captura de entradas, calculo de movimientos, ataques, etc.
    }

    private void draw() {
        cc.draw();
    }

    public static int getFPS() {
        return fps;
    }

    public static int getUPS() {
        return ups;
    }
}