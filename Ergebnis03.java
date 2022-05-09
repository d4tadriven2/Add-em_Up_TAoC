import greenfoot.*;  

public class Ergebnis03 extends Actor{
    AdditionLvl1 al;
    SubtraktionLvl1 sl;
    MultiplikationLvl1 ml;
    DivisionLvl1 dl;
    Gegner gegnerPunkte = new Gegner();
    
    public static int counter = 1; 
    String op;
    public static boolean check1 = false, check2 = false, check3 = false, check4 = false;
    // Darstellung des Ergebnisses
    public Ergebnis03(){
        setImage(new GreenfootImage(verarbeitung(), 30,Color.WHITE, new Color(0,0,0,0)));
    }
    // Abfrage der Rechenart
    public void ergebnis03(String option){
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
            checkReturn = String.valueOf(al.summe);
        }else if(check2){
            checkReturn = String.valueOf(sl.summe);
        }else if(check3){
            checkReturn = String.valueOf(ml.summe);
        }else if(check4){
            checkReturn = String.valueOf(dl.zahl2);
        }else{
            checkReturn = "Fehler in Ergebnis";
        }
        return checkReturn;
    }
    
    public void act(){

    }   
    // Level wird hochgezählt, da Ergebnis 3 immer das richtige Ergebnis ist
    public void ergebnisHitRequest(){
        if(counter <= 9){
            gegnerPunkte.points += 20;
            counter++;
            ergebnisHitNextLevel();
        }else if(counter == 10){ //Nach Level 10 kommt das Bosslevel
            Spieler spielerLeben = new Spieler();
            gegnerPunkte.points += 20;
            Greenfoot.setWorld(new BossLevel());
        }
    }
    // Je nach Rechenart wird das Level neugeladen
    public void ergebnisHitNextLevel(){
        getWorld().removeObject(this);
        if(check1){
            Greenfoot.setWorld(new AdditionLvl1());
        }else if(check2){
            Greenfoot.setWorld(new SubtraktionLvl1());
        }else if(check3){
            Greenfoot.setWorld(new MultiplikationLvl1());
        }else if(check4){
            Greenfoot.setWorld(new DivisionLvl1());
        }else{
        
        }
        
    }  
}