import greenfoot.*;

public class BossSchuss extends Actor{
    // Wenn der Schuss am Rand der Welt ist, soll er entfernt werden
    public void act(){
        if(isAtEdge()){ 
            getWorld().removeObject(this);
        }else{
            spielerhit();
        }
        move(7);
    }    
    // Wenn Spieler getroffen, dann soll der Schuss entfernt werden
    public void spielerhit(){
        Spieler sp = (Spieler) getOneIntersectingObject(Spieler.class);
        if(sp != null){
            this.getWorld().removeObject(this);
            Spieler.spielergetroffen();
        }
    }
}