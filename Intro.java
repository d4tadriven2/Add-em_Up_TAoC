import greenfoot.*;

public class Intro extends World{
    private GreenfootSound Intromusik = new GreenfootSound("core.mp3");
    public boolean pushenter = true;

    public Intro(){    
        super(1000, 600, 1);
        Intromusik.setVolume(80);
        try{
            Intromusik.playLoop();
        }catch(Exception a){
        
        }
        prepare();
    }
    
    public void act(){
        showText("Drücke Space",650,500);
        if(Greenfoot.isKeyDown("space")){
            Intromusik.stop();
            Greenfoot.setWorld(new Selection());
        }   
    }
    // Robocop Animation einfügen
    private void prepare(){   
        Robo robo = new Robo();
        addObject(robo,255,475);
    }
}


