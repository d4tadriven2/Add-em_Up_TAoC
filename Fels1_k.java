import greenfoot.*; 
public class Fels1_k extends Actor{
    int leben = 2;
    public void act(){
        turn(2);
        checktLeben();
    }
    // Wenn der Fels getroffen wird
    public void getroffen(){
        GreenfootSound sfxHit = new GreenfootSound("Hit_Gestein.wav");
        sfxHit.setVolume(90);
        try{
            sfxHit.play();
        }catch(Exception a){
        
        }
        leben--;
    }
    // Überprüfung des Lebens
    public boolean checktLeben(){
        if(leben <= 0){
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    // Felsen sollen nicht überlappen
    public static void entferneKleineUeberlappendeFelsen(Fels1_k FelsM) {
        if (FelsM.isTouching(Fels1_k.class)) {
            FelsM.removeTouching(Fels1_k.class);
        }
    }
}