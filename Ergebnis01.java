import greenfoot.*;

public class Ergebnis01 extends Actor{
    AdditionLvl1 al;
    SubtraktionLvl1 sl;
    MultiplikationLvl1 ml;
    DivisionLvl1 dl;
    
    Gegner gegnerPunkte = new Gegner();
    
    public static boolean check1, check2, check3, check4;
    // Darstellung des Ergebnisses
    public Ergebnis01(){
        setImage(new GreenfootImage(verarbeitung(), 30,Color.WHITE, new Color(0,0,0,0)));
    }
    // Abfrage der Rechenart
    public void ergebnis01(String option){
        check1 = false;
        check2 = false;
        check3 = false;
        check4 = false;
        if(option.equals("Add")){
            check1 = true;
            verarbeitung();
        }else if(option.equals("Sub")){
            check2 = true;
            verarbeitung();
        }else if(option.equals("Mul")){
            check3 = true;
            verarbeitung();
        }else if(option.equals("Div")){
            check4 = true;
            verarbeitung();
        }
    }
    // Verarbeitung der richtigen Rechenart zur Darstellung des Ergebnisses
    public String verarbeitung(){
        String checkReturn = " ";
        if(check1){
            checkReturn = String.valueOf(al.sum2);
            
        }else if(check2){
            checkReturn = String.valueOf(sl.sum2);
            
        }else if(check3){
            checkReturn = String.valueOf(ml.sum2);
            
        }else if(check4){
            checkReturn = String.valueOf(dl.sum2);
            
        }else{
            checkReturn = "hit";
        }
        return checkReturn;
    }
    
    public void act(){

    }  
    // Wenn das Ergebnis getroffen wird, soll es entfernt werden
    public void ergebnisHit(){
        gegnerPunkte.points -= 5;
        getWorld().removeObject(this);
    }
}