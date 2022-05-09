import greenfoot.*;  
import java.util.List;

public class schusss extends Actor{
    public void act(){
       setLocation(getX(),getY()-10);
       Gegner gg = (Gegner) getOneIntersectingObject(Gegner.class);
       Fels1 fels1 = (Fels1) getOneIntersectingObject(Fels1.class);
       Fels1_k fels1_k = (Fels1_k) getOneIntersectingObject(Fels1_k.class);
       Bossgegner boss = (Bossgegner) getOneIntersectingObject(Bossgegner.class);
       // Bedingungen für den Schuss, dass er entfernt werden soll, wenn er am Rand der Welt ist oder Objekte in der Welt trifft
       if (isAtEdge()) {
           getWorld().removeObject(this);
       } else if (gg != null) {
           int randomNumber = Greenfoot.getRandomNumber(100);
           if(randomNumber < 10){
               Booster booster = new Booster();
               this.getWorld().addObject(booster, this.getX(),this.getY());
           }
           this.getWorld().removeObject(this);           
           gg.getroffen();
       } else if (fels1 != null) {
           this.getWorld().removeObject(this);
           fels1.getroffen();
       } else if (fels1_k != null) {
           this.getWorld().removeObject(this);
           fels1_k.getroffen();
       }else if(boss != null){
           int randomNumber2 = Greenfoot.getRandomNumber(100);
           if(randomNumber2 < 10){
               Booster booster2 = new Booster();
               this.getWorld().addObject(booster2, this.getX(),this.getY());
           }
           this.getWorld().removeObject(this);
           boss.getroffen();
       }else{
           ergebnisHit();
       }
    }
    // Wenn Ergebnisse getroffen werden
    public void ergebnisHit(){
        Ergebnis01 ergebnis1 = (Ergebnis01) getOneIntersectingObject(Ergebnis01.class);
        Ergebnis02 ergebnis2 = (Ergebnis02) getOneIntersectingObject(Ergebnis02.class);
        Ergebnis03 ergebnis3 = (Ergebnis03) getOneIntersectingObject(Ergebnis03.class);
        Ergebnis04 ergebnis4 = (Ergebnis04) getOneIntersectingObject(Ergebnis04.class);
        
        if(ergebnis1 != null){
            this.getWorld().removeObject(this);
            ergebnis1.ergebnisHit();
        }
        if(ergebnis2 != null){
            this.getWorld().removeObject(this);
            ergebnis2.ergebnisHit();
        }
        if(ergebnis3 != null){
            this.getWorld().removeObject(this);
            ergebnis3.ergebnisHitRequest();
        }
        if(ergebnis4 != null){
            this.getWorld().removeObject(this);
            ergebnis4.ergebnisHit();
        }
    }
}