import greenfoot.*; 
//import java.lang.Object;
//import greenfoot.MouseInfo;

public class Selection extends World{
    private GreenfootSound musik = new GreenfootSound("Stage_Select.mp3");
    Ergebnis01 ergbn1 = new Ergebnis01(); 
    Ergebnis02 ergbn2 = new Ergebnis02(); 
    Ergebnis03 ergbn3 = new Ergebnis03(); 
    Ergebnis04 ergbn4 = new Ergebnis04(); 
    
    public Selection(){
        super(1000, 600, 1);
    }
    
    public void act(){
        musik.setVolume(70);
        try{
            musik.playLoop();
        }catch(Exception a){
        
        }
        //Folgende if-Anweisungen zum Starten der jeweiligen Rechenart im Menü
        if(Greenfoot.isKeyDown("1")){
            ergbn1.ergebnis01("Add"); 
            ergbn2.ergebnis02("Add");
            ergbn3.ergebnis03("Add");
            ergbn4.ergebnis04("Add");
            musik.stop();
            GameMusik.playMusic();
            Greenfoot.setWorld(new AdditionLvl1());
        }
        if(Greenfoot.isKeyDown("2")){
            ergbn1.ergebnis01("Sub"); 
            ergbn2.ergebnis02("Sub"); 
            ergbn3.ergebnis03("Sub"); 
            ergbn4.ergebnis04("Sub"); 
            musik.stop();
            GameMusik.playMusic();
            Greenfoot.setWorld(new SubtraktionLvl1());
        }
        if(Greenfoot.isKeyDown("3")){
            ergbn1.ergebnis01("Mul"); 
            ergbn2.ergebnis02("Mul"); 
            ergbn3.ergebnis03("Mul"); 
            ergbn4.ergebnis04("Mul"); 
            musik.stop();
            GameMusik.playMusic();
            Greenfoot.setWorld(new MultiplikationLvl1());
        }
        if(Greenfoot.isKeyDown("4")){
            ergbn1.ergebnis01("Div"); 
            ergbn2.ergebnis02("Div");
            ergbn3.ergebnis03("Div");
            ergbn4.ergebnis04("Div");
            musik.stop();
            GameMusik.playMusic();
            Greenfoot.setWorld(new DivisionLvl1());
        }
    }
}



