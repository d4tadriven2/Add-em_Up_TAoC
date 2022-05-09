import greenfoot.*;  
public class BossHit extends Actor{
    int counter = 0;
    public void act() {
        counter++;
        if(1 == counter){
            setImage("expl_10_0000.png");
        }else if(2 == counter){
            setImage("expl_10_0001.png");
        }else if(3 == counter){
            setImage("expl_10_0002.png");
        }else if(4 == counter){
            setImage("expl_10_0003.png");
        }else if(5 == counter){
            setImage("expl_10_0004.png");
        }else if(6 == counter){
            setImage("expl_10_0005.png");
        }else if(7 == counter){
            setImage("expl_10_0006.png");
        }else if(8 == counter){
            setImage("expl_10_0007.png");
        }else if(9 == counter){
            setImage("expl_10_0008.png");
        }else if(10 == counter){
            setImage("expl_10_0009.png");
        }else if(11 == counter){
            setImage("expl_10_0010.png");
        }else if(12 == counter){
            setImage("expl_10_0011.png");
        }else if(13 == counter){
            setImage("expl_10_0012.png");
        }else if(14 == counter){
            setImage("expl_10_0013.png");
        }else if(15 == counter){
            setImage("expl_10_0014.png");
        }else if(16 == counter){
            setImage("expl_10_0015.png");
        }else if(17 == counter){
            setImage("expl_10_0016.png");
        }else if(18 == counter){
            setImage("expl_10_0017.png");
        }else if(19 == counter){
            setImage("expl_10_0018.png");
        }else if(20 == counter){
            setImage("expl_10_0019.png");
        }else if(21 == counter){
            setImage("expl_10_0020.png");
        }else if(22 == counter){
            setImage("expl_10_0021.png");
        }else if(23 == counter){
            setImage("expl_10_0022.png");
        }else if(24 == counter){
            setImage("expl_10_0023.png");
        }else if(25 == counter){
            setImage("expl_10_0024.png");
        }else if(26 == counter){
            setImage("expl_10_0025.png");
        }else if(27 == counter){
            setImage("expl_10_0026.png");
        }else if(28 == counter){
            setImage("expl_10_0027.png");
        }else if(29 == counter){
            setImage("expl_10_0028.png");
        }else if(30 == counter){
            setImage("expl_10_0029.png");
        }else if(31 == counter){
            setImage("expl_10_0030.png");
        }else if(32 == counter){
            setImage("expl_10_0031.png");
        }else{
            getWorld().removeObject(this);
        }
    }     
}