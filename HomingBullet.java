public class HomingBullet extends Bullet {
  
  HomingBullet(int idd,int typee,short xx, short yy,float anglee, float velocityy,int diameterr){
    super(idd, typee,xx, yy,anglee, velocityy, diameterr);

  }
  public void display() {


  }
  public boolean process() {
    return true;
  }
  
}