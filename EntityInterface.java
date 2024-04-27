import java.awt.image.BufferStrategy;

interface EntityInterface {

 short getX();
 short getY();
 void setId(int id);
 int getId();
 void display(Graphics2D g);
 boolean process();
}
