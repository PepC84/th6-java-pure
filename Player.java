import java.awt.image.BufferStrategy;
public class Player implements EntityInterface {
    protected int id;
    private short diameter = 5;
    private float velocity = 5;
    private short x,y;
    private float angle = 90;
    Player(int id,short initialX, short initialY) {
        this.id = id;
        this.x = initialX;
        this.y = initialY;
    }
    public short getX(){
        return this.x;
    }
    public short getY(){
        return this.y;
    }
    public void setId(int newId) {
        this.id = newId;
    }
    public int getId() {
        return this.id;
    }
    public void setDiameter(short newD){
        this.diameter = newD;
    }
    public void setVelocity(float v) {
        this.velocity = v;
    }
    public void setAngle(float newAngle) {
        this.angle = newAngle;
    }
    public void setXY(short x , short y) {
        this.x =x;
        this.y =y;
        /*
        if(x && y) {            // I made this up to look cool hopefully it works (fix later lol)
        this.x = x;
        this.y = y;
        } else if(x){
            this.x = x;
        } else if(y) {
            this.y = y;
        }
        */
    }
    
    public void display() {
        /*
        g.setColor(Color.red);
        g.fillRect(x,y,x+diameter,y+diameter);
        */
    }
    public boolean process() {
        move();
        return true;

    }
    public void move() {
        //IM IN LOVE WITH WRITING THIS
        float diagFix = 1;
        if(Main.isDown + Main.isUp >= 1) {        // ihad a way beter way to do it b ut im a sucker
            if(Main.isLeft + Main.isRight >= 1) {  
                diagFix = Main.INV_SQRT_TWO;
            }
        }
        
        this.x +=  diagFix * (this.velocity * ( Main.isRight -  Main.isLeft)) ;
        this.y +=  diagFix * (this.velocity * ( Main.isRight -  Main.isDown)) ;
        // anddDDDDDD writing commenets!!!
    }
    
}
