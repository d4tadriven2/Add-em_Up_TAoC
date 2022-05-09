import greenfoot.*;  

public class Explosion extends Actor{
    int counter = 0;
    public void act() {
        counter++;
            if(1 == counter){
              setImage("ex1.png");
            }else if(2 == counter){
              setImage("ex2.png");
            }else if(3 == counter){
              setImage("ex3.png");
            }else if(4 == counter){
              setImage("ex4.png");
            }else if(5 == counter){
              setImage("ex5.png");
            }else if(6 == counter){
              setImage("ex6.png");
            }else if(7 == counter){
              setImage("ex7.png");
            }else if(8 == counter){
              setImage("ex8.png");
            }else if(9 == counter){
              setImage("ex9.png");
            }else{
              getWorld().removeObject(this);
            }
    }  
}