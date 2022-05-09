import greenfoot.*;

public class End extends World{
    public static GreenfootSound endMusic = new GreenfootSound("End_Screen.mp3");
    public End(){    
        super(1000, 600, 1); 
        endMusic.setVolume(80);
        try{
            endMusic.playLoop();
        }catch(Exception a){
        
        }
        prepare();
    }
    
    public void act(){
        showText("Drücke Enter", 500, 390);
        
        if(Greenfoot.isKeyDown("Enter")){
            Greenfoot.setWorld(new End2());
        }
    }
    // Robocop Animation wird eingefügt
    private void prepare(){   
        Robo robo = new Robo();
        addObject(robo,255,475);
    }
}