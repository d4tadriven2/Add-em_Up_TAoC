import greenfoot.*; 
public class Hintergrund extends Actor{
    public GifImage hintergrund = new GifImage("sterne.gif");
    public void act() {
        this.setImage(hintergrund.getCurrentImage());
    } 
}
