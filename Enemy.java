public class Enemy implements EntityInterface {
    protected int id;
    private short diameter = 5;
    private float velocity = 5;
    private short x,y;
    private float angle = 90;
    Enemy(int id,short initialX, short initialY) {
        this.id = id;
        this.x = initialX;
        this.y = initialY;
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
    public short getX() {
        return this.x;
    }
    public short getY() {
        return this.y;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int newId) {
        this.id = newId;
    }
    public void display() {
    }
    public boolean process() {
        return true;    
    }
       
}
