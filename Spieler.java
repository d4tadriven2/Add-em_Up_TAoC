import greenfoot.*; 
import java.util.*;

public class Spieler extends Actor{
    private boolean rightanim,leftanim;
    private GreenfootImage ohnedreh;
    private GreenfootImage linksdreh1;
    private GreenfootImage linksdreh2;
    private GreenfootImage linksdreh3;
    private GreenfootImage linksdreh4;
    private GreenfootImage rechtsdreh1;
    private GreenfootImage rechtsdreh2;
    private GreenfootImage rechtsdreh3;
    private GreenfootImage rechtsdreh4;
    private int Schuss_Schritt;
    private int Schuss_Verzerrung = 25;
    public static int leben = 3;
    
    public static Gegner gegnerPunkte = new Gegner();
    
    // Spieler Grafiken 
    public Spieler(){
        ohnedreh    = new GreenfootImage("chaika_00.png");
        linksdreh1  = new GreenfootImage("chaika_l_01.png");
        linksdreh2  = new GreenfootImage("chaika_l_02.png");
        linksdreh3  = new GreenfootImage("chaika_l_03.png");
        linksdreh4  = new GreenfootImage("chaika_l_04.png");
        rechtsdreh1 = new GreenfootImage("chaika_r_01.png");
        rechtsdreh2 = new GreenfootImage("chaika_r_02.png");
        rechtsdreh3 = new GreenfootImage("chaika_r_03.png");
        rechtsdreh4 = new GreenfootImage("chaika_r_04.png");
        setImage(ohnedreh);
    }
   
    public static int getLeben(){
        return leben;
    }
   
    // Spieler Animation bei jeweiliger Bewegung
    public void switchImageLinks(){
        if(getImage()==ohnedreh)
                setImage(linksdreh1);
        else if(getImage()==linksdreh1)
                setImage(linksdreh2);
        else if(getImage()==linksdreh2)
                setImage(linksdreh3);
        else if(getImage()==linksdreh3)
                setImage(linksdreh4);        
    }
    
    public void switchImageLinksBack(){
        if(getImage()==linksdreh4)
            setImage(linksdreh3);
        else if(getImage()==linksdreh3)
            setImage(linksdreh2);
        else if(getImage()==linksdreh2)
            setImage(linksdreh1);   
        else if(getImage()==linksdreh1)
            setImage(ohnedreh);       
    }
    
    public void switchImageRechts(){
        if(getImage()==ohnedreh)
            setImage(rechtsdreh1);
        else if(getImage()==rechtsdreh1)
            setImage(rechtsdreh2);
        else if(getImage()==rechtsdreh2)
            setImage(rechtsdreh3);
        else if(getImage()==rechtsdreh3)
            setImage(rechtsdreh4);         
    }
    
    public void switchImageRechtsBack(){
        if(getImage()==rechtsdreh4)
            setImage(rechtsdreh3);
        else if(getImage()==rechtsdreh3)
            setImage(rechtsdreh2);
        else if(getImage()==rechtsdreh2)
            setImage(rechtsdreh1);   
        else if(getImage()==rechtsdreh1)
            setImage(ohnedreh);      
    }  
    // Spieler Bewegung mit Animation
    public void act(){  
        if(Greenfoot.isKeyDown("W")){
            setLocation(getX(),getY()-5);
        }
        if(Greenfoot.isKeyDown("S")){
            setLocation(getX(),getY()+5);
        }
        if(Greenfoot.isKeyDown("A")){
            setLocation(getX()-5,getY());
            switchImageLinks();
            leftanim = false;
        }
        if(Greenfoot.isKeyDown("D")){
            setLocation(getX()+5,getY());
            switchImageRechts();
            rightanim = false;
        } 
        // Animation Bedingungen
        if(!rightanim&&!Greenfoot.isKeyDown("D")){
            switchImageRechtsBack();
        }
        if(!leftanim&&!Greenfoot.isKeyDown("A")){
            switchImageLinksBack();
        }
        // Schuss Animation
        if(Greenfoot.isKeyDown("space")){
            fireshot();
        }
        Schuss_Schritt ++;
        booster();
        // Spieler soll nicht über die Welt  hinaus fliegen
        if(getX() < getImage().getWidth()/2){ 
            setLocation(getImage().getWidth()/2, getY());
        }
        //X Links
        if(getX() >= getWorld().getWidth()-getImage().getWidth()/2){ 
            setLocation(getWorld().getWidth()-getImage().getWidth()/2, getY());
        }
        //oberes Y
        if(getY() - getImage().getHeight()/2 < 0){ 
            setLocation(getX(),getImage().getHeight()/2);
        }
        //Unteres Y
        if(getY() + getImage().getHeight()/2 > getWorld().getHeight()){ 
            setLocation(getX(), getWorld().getHeight() - getImage().getHeight()/2);
        }
    }  
    // Booster für schnellere Schüsse
    public void booster(){
        Booster bb = (Booster) getOneIntersectingObject(Booster.class);
        if(bb != null){
            getWorld().removeObject(bb);
            Schuss_Verzerrung = 10;
            GreenfootSound sfxHit = new GreenfootSound("boost_aufnahme.wav");
            sfxHit.setVolume(90);
            try{
                sfxHit.play();
            }catch(Exception a){
            
            }
        }
    }
    // Schussfunktion
    public void fireshot(){
        if(Schuss_Schritt >= Schuss_Verzerrung){
            schusss shoot = new schusss();
            getWorld().addObject(shoot,getX(),getY()-25);
            shoot.setImage("schuss_00.png");
            Schuss_Schritt = 0;
            GreenfootSound sfx = new GreenfootSound("shoot.wav");
            sfx.setVolume(90);
            if(Greenfoot.isKeyDown("space")){
                try{
                    sfx.play();
                }catch(Exception a){
                
                }
            }
        }
    }
    // Wenn der Spieler getroffen wird
    public static void spielergetroffen(){
        GreenfootSound sfxHit = new GreenfootSound("Hit_spieler.wav");
        sfxHit.setVolume(90);
        sfxHit.play();
        gegnerPunkte.points -= 5;
        leben--;
        if(leben == 0){
            GameMusik.inGameMusik.stop();
            BossLevel.bossmusik.stop();
            gegnerPunkte.points -= 10;
            GameOver go = new GameOver();
            Greenfoot.setWorld(go);
        }
    } 
 }