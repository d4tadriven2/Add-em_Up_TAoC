import greenfoot.*;  

public class GameMusik extends Actor{
    public static GreenfootSound inGameMusik = new GreenfootSound("Level_Musik.mp3");
    public void act(){
        
    }
    
    public static void playMusic(){
        inGameMusik.setVolume(50);
        try{
            inGameMusik.playLoop();
        }catch(Exception a){
        
        }
    }
}