class Bullet implements EntityInterface{
    int id,type,diameter;
    short x,y;
    int hitboxX,hitboxY;
    int delayFrame = 0;
    int framesLeft;
    float velocityf,anglef;
    boolean autoDelete = false;
    boolean destroyed = false;
    int radius = diameter >> 1;
      Bullet(int idd,int typee,short xx, short yy,float anglee, float velocityy,int diameterr) {
        id=idd;
        type =typee;
        x = xx;
        y=yy;
        anglef=anglee;
        velocityf = velocityy;
        hitboxX=hitboxY=diameter=diameterr;
        while(anglef >= 180) { anglef -= 360; }
        while(anglef < -180) { anglef += 360; }
      }
    public boolean process() {
        if(visibleCheck() == false || destroyed == true)  {
            return false;
        }
        return true;
    }
    
    public void display() {
       
    }
    public void moveBasicLinearBullet() {
      x += velocityf * Math.cos(Math.toRadians(anglef)) ;
      y += velocityf * Math.sin(Math.toRadians(anglef)) ;
    }
    public void setId(int id) {
        this.id = id;
    }
    // LOVE IT WHEN U SEE THE GETERS AND SETTERS (fix later i promis)
    public int getId() {
        return this.id;
    }
    public short getX() {
        return this.x;
    }
    public short getY() {
        return this.y;
    }
    public void setX(short xx) {
      x = xx; 
    }
    public void setY(short yy) {
      y = yy;
    }
    public void setAngle(float anglee) {
      anglef = anglee;
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
    public void setSpeed(float newVelocity) {
     velocityf = newVelocity; 
    }
  /*
    void moveAcceleratedBullet() {
      velocity += acceleration  * deltaTimeAdjusted * 0.5f;
      x += constrain(velocity,minVelocity,maxVelocity) * cos(radians(angle)) *  deltaTimeAdjusted;
      y += constrain(velocity,minVelocity,maxVelocity) * sin(radians(angle)) *  deltaTimeAdjusted;
      velocity += acceleration  * deltaTimeAdjusted * 0.5f;
    }
    */
    

    
    private boolean visibleCheck() {
        if(y >  Main.CLIPMAXY  + diameter||y < Main.CLIPMINY  - diameter ||x > Main.CLIPMAXX  + diameter || x <  Main.CLIPMINX  - diameter) {
       destroyed= true;
         return false;
       } 
       return true;
    }
}
