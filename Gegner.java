import greenfoot.*;

public class Gegner extends Actor{
    public Galaxy galaxy = (Galaxy) getWorld();
    int leben = 2;
    public boolean richtung = true;
    int counter = 0;
    int einschuss= 0;
    // Punkte Sammlung für Ranking
    public static int points = 0;
    Gschuss s = new Gschuss();
    
    public Gegner(){
        
    }

    public void act(){
        followMoving(getX());
        counter++;
        checktLeben();
        if(counter >= 150){
            gegnerShoot();
            counter = 0;
        }
    }
    // Schuss des Gegners
    public void gegnerShoot(){
        try{
        getWorld().addObject(s, getX(), getY()+5);
        GreenfootSound sfxHit = new GreenfootSound("Gegner_Schuss.wav");
        sfxHit.setVolume(90);
        sfxHit.play();
        }catch(Exception a){
        
        }
    }
    // Wenn der Gegner getroffen wird
    public void getroffen(){
        ExplosionHit exploHit = new ExplosionHit();
        getWorld().addObject(exploHit, getX(), getY());
        
        GreenfootSound sfxHit = new GreenfootSound("gegner_hit.wav");
        sfxHit.setVolume(90);
        try{
            sfxHit.play();
        }catch(Exception a){
        
        }
        
        points += 5;
        leben --;
    }
    // Überprüfung des Lebens
    public boolean checktLeben(){
        if(leben <= 0){
            Explosion explo = new Explosion();
            getWorld().addObject(explo, getX(), getY());
            
            GreenfootSound sfxDistroy = new GreenfootSound("Gegner_Explosion.wav");
            sfxDistroy.setVolume(90);
            try{
                sfxDistroy.play();
            }catch(Exception a){
            
            }
            getWorld().removeObject(this);
            points += 10;
            return true;
        }
        return false;
    }
    // Gegner folgt Spieler
    public void followMoving(int x){
        Spieler spieler = (Spieler)getWorld().getObjects(Spieler.class).get(0); 
        turnTowards(spieler.getX(), spieler.getY()-200);
        move(1);
        setRotation(0);
    }
    // Gegner sollen beim spawnen nicht überlappen
    public static void noOverlapping(Gegner Gegner2){
        if(Gegner2.isTouching(Gegner.class)){
            Gegner2.removeTouching(Gegner.class);
        }
    }
}