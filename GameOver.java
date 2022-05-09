import greenfoot.*; 

public class GameOver extends World{
    private GreenfootSound gameOverMusic = new GreenfootSound("Game_Over.mp3");
    
    public GameOver(){  
        super(1000, 600, 1);      
        showText("Drücke >R<", 500, 400);
        
        Ergebnis03 level = new Ergebnis03();
        level.counter = 1;
        
        Spieler spielerLeben = new Spieler();
        spielerLeben.leben = 3;
        
        GameMusik.inGameMusik.stop();
        gameOverMusic.setVolume(80);
        try{
            gameOverMusic.play();
        }catch(Exception a){
        
        }

    }
    
     public void act(){
        if(Greenfoot.isKeyDown("R")){
            gameOverMusic.stop();
            Greenfoot.setWorld(new Rangliste());
        }
        if(Greenfoot.isKeyDown("M")){
            gameOverMusic.stop();
            Greenfoot.setWorld(new Selection());
        }
        if(Greenfoot.isKeyDown("Q")){
            gameOverMusic.stop();
            System.exit(0);
        }
        
    } 
}
