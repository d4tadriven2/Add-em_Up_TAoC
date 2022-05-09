import greenfoot.*; 

public class Booster extends Actor{
    public int timer = 1000;    
    public int count = 400;
    public void act(){
        for(int i=0;i<timer;i++){
            if(i==0){
                counter();  
            }
        }
    }
    // Dauer bis der Booster wieder automatisch entfernt wird
    public void counter(){
        count --;
        if(count == 0){
            this.getWorld().removeObject(this);
        }
    }
}
