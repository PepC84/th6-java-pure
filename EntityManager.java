import java.util.HashMap;
import java.util.ArrayList;

public class EntityManager <T extends EntityInterface> {
  private ArrayList <T> objPool = new ArrayList<T>();
  private ArrayList <T> objBuffer = new ArrayList<T>();
  private boolean objBufferEmpty = true;
  private boolean loopingProcess = false;
  private HashMap <Integer,T> idToObj = new HashMap<>();

  private int currentId = 0;
  //bulletTable.addColumn("id");
  //bulletTable.addColumn("destroyed");
  EntityManager(){
    //statusTable.addColumn("
  }
  
  T nearestNeighbor(T origin) {
    T closest = null;
    
    short x = origin.getX();
    short y = origin.getY();
    int lastDistance = -1;
    for(T part : objPool) {
      if(closest == null) {
        closest = part;
        lastDistance =  (part.getX() - x) * (part.getX() - x ) +   (part.getY() - y) * (part.getY() - y );
        continue;
      }
      int d = (part.getX() - x) * (part.getX() - x ) +   (part.getY() - y) * (part.getY() - y );
      if(lastDistance > d){
        lastDistance = d;
        closest = part;
      }
    }
    return closest; 
  }
  
  void loopProcess() {
    loopingProcess = true;
    for(T part : objPool){
      if(part.process()) {
        continue;
      }
      idToObj.remove(part.getId());
      part = null;
    }
    loopingProcess = false;
    if(objBufferEmpty == false) {
      objPool.addAll(objBuffer);
      objBuffer.clear();
      objBufferEmpty = true;
    }
  }
  void loopDisplay() {
    for(T part : objPool) {
      part.display();
    }
  }

  T getObj(int id) {
    return idToObj.get(id);
  }
  void insert(T obj) {
    
    if(loopingProcess == true) {
      objBuffer.add(obj); 
      objBufferEmpty = false; 
    } else {
      objPool.add(obj);
    }
    idToObj.put(currentId,obj);
    obj.setId(currentId);
    currentId++;
  }
  ArrayList <T> getObjPool(){
    return objPool;
  }
  
}
