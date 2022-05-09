import greenfoot.*;
public class Fels1 extends Actor{
    int leben = 2;
    public void act(){
        turn(0);
        bewegung();
        if(isAtEdge()){
                getWorld().removeObject(this);    
            } 
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
    public static void entferneGroßeUeberlappendeFelsen(Fels1 FelsM) {
        if (FelsM.isTouching(Fels1.class)) {
            FelsM.removeTouching(Fels1.class);
        }
    }
    // Felsen bewegen sich nach unten
    public void bewegung(){
        setLocation(getX(),getY() +1);
    }
}