public class Main {
    //reminder to move these variables
    public final static int programW = 1280;
    public final static int programH = 720;
    public final static int CLIPMINX = 40;
    public final static int CLIPMAXX = 1240;
    public final static int CLIPMINY = 40;
    public final static int CLIPMAXY = 680;
    public final static int CENTERX = 630;
    public final static int CENTERY = 350;
    public static   int playerInitialPosX = CENTERX;
    public static   int playerInitialPosY = CENTERY - CENTERY/5;
    public static   int playerdiameter= 5;
    public static   int playerSpeed = 5;
    public static   int bossInitialPosX = CENTERX/2;
    public static   int bossInitialPosY = CENTERY/5;
    public static   int bossDiameter = 5;
    public static final float INV_SQRT_TWO = 0.70710678118f;
    public static void main(String[] args) throws Exception {
        GameEngine game = new GameEngine("silly goose game", programW,programH);
        game.startGame();
        game.startMainLoop();
    }


}

