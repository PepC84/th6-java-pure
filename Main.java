public class Main {
final int programW = 1280;
final int programH = 720;
final int CLIPMINX = 40;
final int CLIPMAXX = 1240;
final int CLIPMINY = 40;
final int CLIPMAXY = 680;
final int CENTERX = 630;
final int CENTERY = 350;
  int playerInitialPosX = CENTERX;
  int playerInitialPosY = CENTERY - CENTERY/5;
  int playerdiameter= 5;
  int playerSpeed = 5;
  int bossInitialPosX = CENTERX/2;
  int bossInitialPosY = CENTERY/5;
  int bossDiameter = 5;
final float INV_SQRT_TWO = 0.70710678118f;
final float SIXTY_E_NEG3 = 60e-3f ; //0.06  idk why i did this
final float TEN_E_3_OVER_SIXTY = 1000/60f; //16.66666 
  float deltaTime;
  float deltaTimeAdjusted;
  long  lastTime = System.currentTimeMillis();
    public static void main(String[] args) throws Exception {
        GameEngine game = new GameEngine("silly goose game", 1280, 720);
        game.startGame();
        game.startMainLoop();
    }


}

