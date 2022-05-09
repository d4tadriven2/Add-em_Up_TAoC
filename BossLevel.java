import greenfoot.*;  
public class BossLevel extends World{
    public GifImage hintergrund = new GifImage("sterne.gif");
    public static GreenfootSound bossmusik = new GreenfootSound("Boss_Musik.mp3");
    Bossgegner bossgegner = new Bossgegner();
    Spieler sp;
    public BossLevel(){    
        super(1000, 600, 1); 
        GameMusik.inGameMusik.stop();
        bossmusik.setVolume(80);
        try{
            bossmusik.playLoop();
        }catch(Exception a){
        
        }
        for(GreenfootImage img : hintergrund.getImages()){
            img.scale(getWidth(), getHeight());
        }
        boss();
        player();
    }
    
    public void act(){
        setBackground(hintergrund.getCurrentImage());
        lebensAnzeige();
    }
    // Bossgegner wird im Spiel platziert
    public void boss(){
        addObject(bossgegner, 500, 50);
    }
    // Spieler wird im Spiel platziert
    public void player(){
        Spieler spieler = new Spieler();
        addObject(spieler,getWidth()/2,getHeight()-35); 
    }
    // Lebensanzeige vom Spieler und Boss
    public void lebensAnzeige(){
        showText("Boss: " + bossgegner.getBossLeben(),75,55); 
        showText("Leben: " + sp.getLeben(),75,25);
    }
}