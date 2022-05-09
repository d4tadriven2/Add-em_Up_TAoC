import greenfoot.*;

public class Start extends World{
    public GreenfootSound musik = new GreenfootSound("Startbildschirm.mp3");
    
    public Start(){    
        super(500, 500, 1);
        prepare();
    }
    // Titel Bildschirm anzeigen
    private void prepare(){
        Titel titel = new Titel();
        addObject(titel, getWidth()/2,getHeight()/2);
    }
}
