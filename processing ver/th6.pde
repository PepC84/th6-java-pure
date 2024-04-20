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
final float INV_SQRT_TWO = 0.70710678118;
final float SIXTY_E_NEG3 =60e-3 ; //60e-3 means 0.06 //is the usual framerate (60) times deltaTime in millis e.j. 16.6667 (16.666666 * SIXTY_eNEG3 yields 1)
final float TEN_E_3_OVER_SIXTY = 1e3/60;
  boolean frameMod15 = false;
  boolean frameMod3 = false;
  float deltaTime;
  float deltaTimeAdjusted;
  long  lastTime = millis();
//ArrayList <Bullet> bullets = new ArrayList<Bullet>();
//ArrayList <Bullet> bulletsTemp = new ArrayList<Bullet>();
//Table bulletTable = new Table();
//ArrayList <Player> players = new ArrayList<Player>();
//ArrayList <Enemy> enemies = new ArrayList<Enemy>();
 //ArrayList <Boss> bosses = new ArrayList<Boss>();
//MetaObject <HomingBullet> homingBulletMeta = new MetaObject<>();
void settings() {
  size(programW,programH);
}
void setup() {
  frameRate(200);
  imageMode(CENTER);
  //bosses.append( new Boss(bossInitialPosX,bossInitialPosY,bossDiameter));
  //players.append( new Player(playerInitialPosX,playerInitialPosY,playerSidesLength,playerSpeed ));
 // bulletTable.addColumn("id");
  //bulletTable.addColumn("destroyed");
}
void draw() {
   deltaTime = ((millis() - lastTime));
   lastTime = millis();
   deltaTimeAdjusted = deltaTime * SIXTY_E_NEG3;
   frameMod15 = false;
   frameMod3 = false;
   if(frameCount % 15 == 0) {
     frameMod15 = true;
   } 
   if(frameCount % 3 == 0) {
     frameMod3 = true;   
   } 
   background(0);
   stroke(255,0,0);
   fill(255);
   rect(CLIPMINX,CLIPMINY,CLIPMAXX - CLIPMINX,CLIPMAXY - CLIPMINY);
   stroke(0);
   gameOrders();
   /*
   for(Boss part : bosses) {
    part.display(); 
   }
   for(Enemy part : enemies) {
     part.display();
   }
   for(Player part : players) {
     part.display();
     part.move();
   }
   for(BaseBullet part : bullets) {
     part.display();
   }
   
   bullets.addAll(bulletsTemp);
   bulletsTemp.clear();
   */
   
}
void gameOrders() {
  
}

//class
interface EntityInterface {
 int getX();
 int getY();
 PVector getXY();
 void setId(int id);
 int getId();
 boolean display();
}

public class EntityManager <T extends EntityInterface>{
  private Table slowPosTable = new Table();
  private ArrayList <T> objPool = new ArrayList<T>();
  private ArrayList <T> objBuffer = new ArrayList<T>();
  private boolean objBufferEmpty = true;
  private boolean loopingPool = false;
  private HashMap <Integer,T> idToObj = new HashMap<>();
  private int currentId =0 ;
  //bulletTable.addColumn("id");
  //bulletTable.addColumn("destroyed");
  EntityManager(){
    //statusTable.addColumn("
  }
  PVector nearestNeighbor(PVector p) {
    int i = 0;
    for(T part :objPool) {
      
      part.getXY(); 
    }
    return closest =
  }
  void loopDisplay() {
    
    loopingPool = true;
    for(T part : objPool) {
      if(part.display()) {
        
        continue;
      }
      idToObj.remove(part.getId());
      part = null;
    }
    loopingPool = false;
    if(objBufferEmpty == false) {
      objPool.addAll(objBuffer);
      objBuffer.clear();
      objBufferEmpty = true;
    }
  }
  void insert(T obj) {
    
    if(loopingPool == true) {
      objBuffer.add(obj); 
      objBufferEmpty = false; 
    } else {
      objPool.add(obj);
    }
    idToObj.put(currentId,obj);
    obj.setId(currentId);
    currentId++;
    if(currentId < 0 ) { // I forgot how overflow works
      currentId = 0;
    }
  }
  ArrayList getObjPool(){
    return objPool;
  }
 
  
  
  
}
/*
class MetaObject <T extends ObjectInterface> {
  Table DestroyedTable = new Table();
  ArrayList <T> ObjPool = new ArrayList<T>();
  ArrayList <T> Temp = new ArrayList<T>();
  MetaObject() {
  }
  void display() {
   for(T part : ObjPool) {
     part.display();
     
   }
  }
  //void setAngleHomingShot() {
  //}
}
class MetaEntity <T extends ObjectInterface> extends MetaObject {
  MetaEntity() {
  }
 void display() {
  super.display(); 
 }
}
interface ObjectInterface {
 
 boolean display();
}
class BaseBullet implements ObjectInterface{
  int id,type,displayX,displayY,diameter;
  int hitboxX,hitboxY;
  int delayFrame = 0;
  int framesLeft;
  float x,y,velocity,angle;
  boolean autoDelete = false;
  boolean destroyed = false;
  int radius = diameter >> 1;
    BaseBullet(int idd,int typee,float xx, float yy,float anglee, float velocityy,int diameterr) {
      id=idd;
      type =typee;
      x = xx;
      y=yy;
      angle=anglee;
      velocity = velocityy;
      hitboxX=hitboxY=diameter=diameterr;
      while(angle >= 180) { angle -= 360; }
      while(angle < -180) { angle += 360; }
    }
  boolean display() {
   if(visibleCheck() == false || destroyed == true)  {
     return false;
   }
   return true;
  }
  void setX(float xx) {
    x = xx; 
  }
  void setY(float yy) {
    y = yy;
  }
  void setXY(float xx, float yy) {
   x = xx;
   y = yy;
  }
  void setAngle(float anglee) {
    angle = anglee;
  }
  void setAutoDelete(int framesLeftt, boolean settingg) {
    autoDelete = settingg;
    framesLeft = framesLeftt;
  }
  void setBulletType(int newBulletType) {
    type = newBulletType;
  }
  void setHitboxXY(int newHitboxX, int newHitboxY){
    hitboxX = newHitboxX;
    hitboxY = newHitboxY;
  }
  void setSpeed(float newVelocity) {
   velocity = newVelocity; 
  }
/*
  void moveAcceleratedBullet() {
    velocity += acceleration  * deltaTimeAdjusted * 0.5f;
    x += constrain(velocity,minVelocity,maxVelocity) * cos(radians(angle)) *  deltaTimeAdjusted;
    y += constrain(velocity,minVelocity,maxVelocity) * sin(radians(angle)) *  deltaTimeAdjusted;
    velocity += acceleration  * deltaTimeAdjusted * 0.5f;
  }
  */
  /*
  void moveBasicLinearBullet() {
        x += velocity * cos(radians(angle)) *  deltaTimeAdjusted;
      y += velocity * sin(radians(angle)) *  deltaTimeAdjusted;
  }
  */
  /*
  boolean visibleCheck() {
      if(y > CLIPMAXY + diameter||y < CLIPMINY - diameter ||x > CLIPMAXX + diameter || x < CLIPMINX  - diameter) {
     destroyed= true;
       return false;
     } 
     return true;
  }
}
class HomingBullet extends BaseBullet implements ObjectInterface{
  
  HomingBullet(int idd,int typee,float xx, float yy,float anglee, float velocityy,int diameterr){
    super(idd, typee,xx, yy,anglee, velocityy, diameterr);
  }
  boolean display() {
     if(destroyed == true) {
       return false;
     }
     if(super.visibleCheck() == false ) {
       
      return false; 
     }
     return true;
  }
    
}
*/