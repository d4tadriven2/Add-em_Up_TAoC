import greenfoot.*;
import java.util.*;
import javax.swing.*;
public class Galaxy extends World{
    Gegner[] ggs = new Gegner[4];
    Gegner g1 = new Gegner();
    Ergebnis03 levelAnzeige = new Ergebnis03();
    public GifImage hintergrund = new GifImage("sterne.gif");
    Spieler sp;
    
    public int xWert;
    
    public Galaxy(){ 
        super(1000, 600, 1,false);
        for(GreenfootImage img : hintergrund.getImages()){
            img.scale(getWidth(), getHeight());
        }
        prepare();   
    }
    
    public void act(){
        showText("Leben: " + sp.getLeben(),75,25);
        punkteAnzeige();
        levelAnzeige();
        setBackground(hintergrund.getCurrentImage());
    }
    
    // Aktuelle Punkte InGame
    private void punkteAnzeige(){
        int punkte = g1.points;
        showText("Punkte: " + punkte, 905, 25);
    }
    // Aktuelles Level InGame
    private void levelAnzeige(){
        int level = levelAnzeige.counter;
        showText("Level: " + level, 75, 75);
    }
    
    private void prepare(){
        // Spieler wird eingefügt
        Spieler spieler = new Spieler();
        addObject(spieler,getWidth()/2,getHeight()-35); 
        addObject(g1,450,140);
               
        // Random Felsen und Gegner generieren
        Fels1[] felsarray = new Fels1[3];
        Fels1_k[] felsarray2 = new Fels1_k[4];
        Fels1 FelsM = new Fels1();
        Fels1 FelsN = new Fels1();
        for(int i=0;i<felsarray.length;i++){
            felsarray[i] = new Fels1();
            int felsX = Greenfoot.getRandomNumber(getWidth());
            if(xWert == felsX){
                felsX = Greenfoot.getRandomNumber(getWidth());
            }else {
                xWert = felsX;
            }
            int felsY = Greenfoot.getRandomNumber(300);
            addObject(felsarray[i],felsX,felsY);
            Fels1.entferneGroßeUeberlappendeFelsen(felsarray[i]);
        }
        
        for(int i=0;i<felsarray2.length;i++){
            felsarray2[i] = new Fels1_k();
            int felsX = Greenfoot.getRandomNumber(getWidth());
            if(xWert == felsX){
                felsX = Greenfoot.getRandomNumber(getWidth());
            }else {
                xWert = felsX;
            }
            int felsY = Greenfoot.getRandomNumber(300);
            addObject(felsarray2[i],felsX,felsY);
            Fels1_k.entferneKleineUeberlappendeFelsen(felsarray2[i]);
        }
        // Ab Level 6 kommen 4 Gegner
        if(levelAnzeige.counter > 5){
            for(int i=0;i<ggs.length;i++){
                ggs[i] = new Gegner();
                int ggX = Greenfoot.getRandomNumber(getWidth());
                if(xWert == ggX){
                    ggX = Greenfoot.getRandomNumber(getWidth());
                }else {
                    xWert = ggX;
                }
                int ggY = Greenfoot.getRandomNumber(50);
                addObject(ggs[i],ggX,ggY);
                g1.noOverlapping(ggs[i]);
            }
        }else{
            for(int i=0;i<2;i++){
                ggs[i] = new Gegner();
                int ggX = Greenfoot.getRandomNumber(getWidth());
                if(xWert == ggX){
                    ggX = Greenfoot.getRandomNumber(getWidth());
                }else {
                    xWert = ggX;
                }
                int ggY = Greenfoot.getRandomNumber(50);
                addObject(ggs[i],ggX,ggY);
                g1.noOverlapping(ggs[i]);
            }
        }
    }
}
