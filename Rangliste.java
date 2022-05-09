import greenfoot.*; 
import java.util.*;
import java.io.*;
public class Rangliste extends World{
    public String name = " ";
    Gegner g1 = new Gegner();
    public GifImage hintergrund = new GifImage("sterne.gif");
    private GreenfootSound rangMusik = new GreenfootSound("Rangliste_Musik.mp3");
    Gegner gegnerPunkte = new Gegner(); 
    public Rangliste(){    
        super(1000, 600, 1); 
        BossLevel.bossmusik.stop();
        rangMusik.setVolume(80);
        try{
            rangMusik.playLoop();
        }catch(Exception a){
        
        }
        namensAbfrage();
        for(GreenfootImage img : hintergrund.getImages()){
            img.scale(getWidth(), getHeight());
        }
    }
    
    public void act(){
        setBackground(hintergrund.getCurrentImage());
        if(Greenfoot.isKeyDown("M")){
            gegnerPunkte.points = 0;
            GameMusik.inGameMusik.stop();
            rangMusik.stop();
            Greenfoot.setWorld(new Selection());
        }
        if(Greenfoot.isKeyDown("Q")){
            gegnerPunkte.points = 0;
            GameMusik.inGameMusik.stop();
            rangMusik.stop();
            Greenfoot.stop();
            //System.exit(0);
        }
    }
    
    // Name des Spielers wird abgefragt
    public void namensAbfrage(){
        name = Greenfoot.ask("Name?");
        if(name.length()>35){ 
            showText("Name zu lang! Wähle einen anderen Namen.", 300, 300);
        }else{
            ranking(name);
        }
    }
    
    //Rangliste
    public void ranking(String name) {
        File dateiPunkte = new File("punkte.txt");
        File dateiNamen = new File("namen.txt");
            
        int punkte = g1.points;
           
        //Falls txt leer
        int[] punkteArray = new int[20];
        String[] namenArray = new String[20];
            
        // Punkte Datei lesen und in Array speichern
        try{
            File openPoints = new File("punkte.txt");
            Scanner inputFile = new Scanner(openPoints);
            int i = 0;
            while(inputFile.hasNextInt() && i < punkteArray.length){
                punkteArray[i] = inputFile.nextInt();
                i++;
            }
            inputFile.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Namen Datei lesen und in Array speichern
        try{
            File openNames = new File("namen.txt");
            Scanner inputFile2 = new Scanner(openNames);
            int j = 0;
            while(inputFile2.hasNextLine() && j < namenArray.length){
                namenArray[j] = inputFile2.nextLine();
                j++;
            }
            inputFile2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        // Erspielte Punkte mit Namen zum sortieren an letzter Stelle der
        // Arrays platzieren
        punkteArray[19] = punkte;
        namenArray[19] = name;
            
        // Bubblesort Sortierung für Ranglisten Array
        for(int i = 0; i < punkteArray.length && i < namenArray.length; i++){
            for(int j = 0; j < punkteArray.length-1 && i < namenArray.length-1; j++){
                if(punkteArray[j] < punkteArray[j+1]){
                    int k = punkteArray[j+1];
                    String l = namenArray[j+1];
                    punkteArray[j+1] = punkteArray[j];
                    namenArray[j+1] = namenArray[j];
                    punkteArray[j] = k;
                    namenArray[j] = l;
                }
            }
        }
            
        // Punkte in txt Datei speichern
        try{
            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter("punkte.txt"));
            for(int i = 0; i < punkteArray.length; i++){
                outputWriter.write(Integer.toString(punkteArray[i]));
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Namen in txt Datei speichern
        try{
            BufferedWriter outputWriter2 = null;
            outputWriter2 = new BufferedWriter(new FileWriter("namen.txt"));
            for(int j = 0; j < punkteArray.length; j++){
                outputWriter2.write(namenArray[j] + "");
                outputWriter2.newLine();
            }
            outputWriter2.flush();
            outputWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        // Ausgabe
        showText("RANGLISTE -- TOP 10", 500, 100);
        showText("Platz: 1 -  Punkte: " + punkteArray[0] + " --- " + namenArray[0] + " ", 500, 150);
        showText("Platz: 2 -  Punkte: " + punkteArray[1] + " --- " + namenArray[1] + " ", 500, 180);
        showText("Platz: 3 -  Punkte: " + punkteArray[2] + " --- " + namenArray[2] + " ", 500, 210);
        showText("Platz: 4 -  Punkte: " + punkteArray[3] + " --- " + namenArray[3] + " ", 500, 240);
        showText("Platz: 5 -  Punkte: " + punkteArray[4] + " --- " + namenArray[4] + " ", 500, 270);
        showText("Platz: 6 -  Punkte: " + punkteArray[5] + " --- " + namenArray[5] + " ", 500, 300);
        showText("Platz: 7 -  Punkte: " + punkteArray[6] + " --- " + namenArray[6] + " ", 500, 330);
        showText("Platz: 8 -  Punkte: " + punkteArray[7] + " --- " + namenArray[7] + " ", 500, 360);
        showText("Platz: 9 -  Punkte: " + punkteArray[8] + " --- " + namenArray[8] + " ", 500, 390);
        showText("Platz: 10 - Punkte: " + punkteArray[9] + " --- " + namenArray[9] + " ", 500, 420);
        
        showText("M: Menü", 400, 500);
        showText("Q: Beenden", 600, 500);
        
        // Punkte zurücksetzen
        g1.points = 0;
    }
}