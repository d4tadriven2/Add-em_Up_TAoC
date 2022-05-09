import greenfoot.*; 

public class ExplosionHit extends Actor{
    int counter = 0;
    public void act() {
        counter++;
            if(1 == counter){
              setImage("ex1.png");
            }else if(2 == counter){
              setImage("ex2.png");
            }else if(3 == counter){
              setImage("ex3.png");
            }else{
              getWorld().removeObject(this);
            }
    }
}