import greenfoot.*;

public class Titel extends Actor{
    public GifImage titel = new GifImage("SpaceBG_new.gif");
    public GreenfootSound musik = new GreenfootSound("Startbildschirm.mp3");
    public boolean pushenter = false;
    
    public void act(){
        getWorld().showText("Drücke Enter",240,400); 
        musik.setVolume(80);
        try{
            musik.playLoop();
        }catch(Exception a){
        
        }
        
        this.setImage(titel.getCurrentImage());
        if(Greenfoot.isKeyDown("enter")){
            musik.stop();
            getWorld().removeObject(this);
            Greenfoot.setWorld(new Intro());
        }
    }
}

