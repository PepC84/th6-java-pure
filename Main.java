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
    public static short playerInitialPosX = CENTERX;
    public static short playerInitialPosY = CENTERY - CENTERY/5;
    public static int playerdiameter= 5;
    public static int playerSpeed = 5;
    public static int bossInitialPosX = CENTERX/2;
    public static int bossInitialPosY = CENTERY/5;
    public static int bossDiameter = 5;
    public static final float INV_SQRT_TWO = 0.70710678118f;
    public static short isDown = 0;
    public static short isLeft = 0;
    public static short isRight = 0;
    public static short isUp = 0;
    static Player player1 = new Player(1,playerInitialPosX,playerInitialPosY); 
    
    public static void main(String[] args) throws Exception {
        EntityManager<Player> Players = new EntityManager<>(); 
        Players.insert(player1);
        EntityManager<Enemy> Enemies = new EntityManager<>();
        EntityManager<Bullet> Bullets = new EntityManager<>();
        System.out.print("WHARTAKJLSD"); 
        GameEngine game = new GameEngine("silly goose game", programW,programH);
        game.startGame();  
        game.startMainLoop();
    }




}

