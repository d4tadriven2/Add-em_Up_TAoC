import greenfoot.*;

public class Gschuss extends Actor{
    public Gschuss(){
        setRotation(180);   
    }
    public void act(){
        setLocation(getX(),getY()+2);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }else{
            spielerhit();
        }
    }    
    // Wenn der Spieler getroffen wird
    public void spielerhit(){
        Spieler sp = (Spieler) getOneIntersectingObject(Spieler.class);
        if(sp != null){
            this.getWorld().removeObject(this);
            Spieler.spielergetroffen();
        }
    }
}
