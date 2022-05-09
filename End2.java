import greenfoot.*;  
public class End2 extends World{
    public GifImage baalregEnd = new GifImage("baalreg.gif");
    public End2(){
        super(1000, 600, 1); 
    }
    
    public void act(){
        setBackground(baalregEnd.getCurrentImage());
        showText("Drücke Enter", 720, 390);
        if(Greenfoot.isKeyDown("Enter")){
            End.endMusic.stop();
            Greenfoot.setWorld(new Rangliste());
        }
        
    }
}