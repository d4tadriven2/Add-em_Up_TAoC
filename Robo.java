import greenfoot.*;

public class Robo extends Actor{
    public GreenfootImage talk0 = new GreenfootImage ("Robo_0.png"); 
    public GreenfootImage talk1 = new GreenfootImage ("Robo_1.png");
    private static  final int Anim_Verzerrung1 = 70;
    private static  final int Anim_Verzerrung2 = 50;
    private int Anim_Schritt;
    
    public void act(){
        Anim_Schritt++;
        if(Anim_Schritt>=Anim_Verzerrung1){
            setImage(talk0);
            Anim_Schritt = 30;
        }
        if(Anim_Schritt==Anim_Verzerrung2){
            setImage(talk1);
            Anim_Schritt = 50;
        }
    }
}
