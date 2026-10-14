package Bai2;

interface CanFly{
   public abstract void fly();

}
interface Canswim{
    public void swim();
}
interface CanFight{
    public void fight();
}
public class ActionCharacter {
    public void fight (){
        System.out.println("Đấm bốc...");
    }
}
class Hero extends ActionCharacter implements CanFight,CanFly,Canswim{
 public void fly(){
     System.out.println("Hero is flying");
 }
 public void swim(){
     System.out.println("Hero is swimming");
 }
}
 class Main {
    public static void main(String[] args){
        Hero h=new Hero();
        Canswim swimmer=(Canswim) h;
        swimmer.swim();
        CanFight fighter = (CanFight) h;
        fighter.fight();
    }
}
