import greenfoot.*; 

public class Bossgegner extends Actor{
    int counter = 0;
    public static int leben = 20;
    Gegner gegnerPunkte = new Gegner(); 
    int punkte = gegnerPunkte.points;
    
    public void act(){
        if(getWorld().getObjects(Spieler.class).isEmpty()){
            return;
        }
        // Boss verfolgt Gegner
        Spieler spieler = (Spieler)getWorld().getObjects(Spieler.class).get(0);
        turnTowards(spieler.getX(), spieler.getY());
        move(2);
        counter++;
        checkLeben();
        // Alle 90 schleifen, soll ein Schuss abgefeuert werden
        if(counter >= 90){
            bossSchuss();
            counter = 0;
        }
    }   
    // Abfeuern des Schusses 
    public void bossSchuss(){
        BossSchuss schuss = new BossSchuss();
        getWorld().addObject(schuss, getX(), getY()+5);
        schuss.setRotation(getRotation());
        
        GreenfootSound sfxShoot = new GreenfootSound("Boss_Schuss.mp3");
        sfxShoot.setVolume(80);
        try{
            sfxShoot.play();
        }catch(Exception a){
        
        }
    }
    // Wenn der Bossgegner getroffen wird
    public void getroffen(){
        BossHit bossHit = new BossHit();
        getWorld().addObject(bossHit, getX(), getY());
        GreenfootSound sfxShoot = new GreenfootSound("Boss_Hit.wav");
        sfxShoot.setVolume(90);
        try{
            sfxShoot.play();
        }catch(Exception a){
        
        }
        punkte += 10;
        leben--;
    }
    // Überprüfung des Lebens
    public void checkLeben(){
        Ergebnis03 levelAnzeige = new Ergebnis03();
        Spieler spielerLeben = new Spieler();
        if(leben <= 0){
            BossLevel.bossmusik.stop();
            GreenfootSound sfxDistroy = new GreenfootSound("boss_explosion.wav");
            sfxDistroy.setVolume(90);
            try{
                sfxDistroy.play();
            }catch(Exception a){
            
            }
            
            getWorld().removeObject(this);
            Greenfoot.setWorld(new End());
            spielerLeben.leben = 3;
            levelAnzeige.counter = 1;
            leben = 20;
        }
    }
    
    public static int getBossLeben(){
        return leben;
    }
}