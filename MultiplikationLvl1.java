import greenfoot.*;

public class MultiplikationLvl1 extends Galaxy{
    public static int zahl1, zahl2, summe, sum2, sum3, sum4, a, b, counter;
    public MultiplikationLvl1(){
        zahl1 = (int) (Math.random()*10)+1;
        zahl2 = (int) (Math.random()*10)+1;
        summe = zahl1*zahl2;
        sum2 = summe + (Greenfoot.getRandomNumber(10)-5);
        sum3 = summe + (Greenfoot.getRandomNumber(10)-5);
        sum4 = summe + (Greenfoot.getRandomNumber(10)-5);
        counter = 100;
        a = 7;
        b = 1;        
        
        showText(zahl1 + " x " + zahl2, 500, 50);            
        // Generieren der Aufgaben, ohne doppelte Zahlen oder negative Ergebnisse  
        for(int i=0; i<counter; i++){
            if(sum2 <= 0){
                sum2 = sum2 + a;
            } 
            if(sum3 <= 0){
                sum3 = sum3 + a;
            }
            if(sum4 <= 0){
                sum4 = sum4 + a;
            }
            if(sum2 == summe){
                sum2 = sum2 + b;
            }
            if(sum3 == summe){
                sum3 = sum3 + b;
            }
            if(sum4 == summe){
                sum4 = sum4 + b;
            }
            if(sum2 == sum3){
                sum2 = sum2 + b;
            }
            if(sum2 == sum4){
                sum2 = sum2 + b;
            }
            if(sum3 == sum4){
                sum3 = sum3 + b;
            }                
        }       
        
        // Random position der Ergebnisse
        // Ergebnis 1
        int x1 = Greenfoot.getRandomNumber(getWidth());
        // Definiton des Bereiches in denen die Ergebnisse dargestellt werden sollen
        if(x1 < 100){
            x1 += 100;
        }else if(x1 > 800){
            x1 -= 100;
        }
        int y1 = Greenfoot.getRandomNumber(getHeight());
        if(y1 < 100){
            y1 += 150;
        }else if(y1 > 400){
            y1 -= 200;
        }
        // Ergebnis 2
        int x2 = Greenfoot.getRandomNumber(getWidth());
        if(x2 < 100){
            x2 += 100;
        }else if(x2 > 800){
            x2 -= 100;
        }
        int y2 = Greenfoot.getRandomNumber(getHeight());
        if(y2 < 100){
            y2 += 150;
        }else if(y2 > 400){
            y2 -= 200;
        }
        // Ergebnis 3
        int x3 = Greenfoot.getRandomNumber(getWidth());
        if(x3 < 100){
            x3 += 100;
        }else if(x3 > 800){
            x3 -= 100;
        }
        int y3 = Greenfoot.getRandomNumber(getHeight());
        if(y3 < 100){
            y3 += 150;
        }else if(y3 > 400){
            y3 -= 200;
        }
        // Ergebnis 4
        int x4 = Greenfoot.getRandomNumber(getWidth());
        if(x4 < 100){
            x4 += 100;
        }else if(x4 > 800){
            x4 -= 200;
        }
        int y4 = Greenfoot.getRandomNumber(getHeight());
        if(y4 < 100){
            y4 += 150;
        }else if(y4 > 400){
            y4 -= 200;
        }
        
        // Verhindern von überlappungen
        if(x1 <= x2 || x1 >= x2){
            x1 += 50;
        }
        
        if(y1 <= y2 || y1 >= y2){
            y2 += 50;
        }
        
        if(x3 <= x4 || x3 >= x4){
            x3 += 50;
        }
        
        if(y3 <= y4 || y3 >= y4){
            y4 += 50;
        }
        //Ergebnisse
        Ergebnis01 solution1 = new Ergebnis01();
        addObject(solution1, x1, y1);
        
        Ergebnis02 solution2 = new Ergebnis02();
        addObject(solution2, x2, y2);
        
        Ergebnis03 solution3 = new Ergebnis03();
        addObject(solution3, x3, y3);
        
        Ergebnis04 solution4 = new Ergebnis04();
        addObject(solution4, x4, y4);
    }
}
