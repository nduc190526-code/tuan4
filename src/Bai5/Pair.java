package Bai5;

public class Pair <K,V> {
    private K key;
    private V value;
   public Pair(K key,V value){
       this.key=key;
       this.value=value;
   }
   public K getKey(){
       return key;
   }
   public V getValue(){
       return value;   }
    public void setValue(V value){
       this.value=value;
    }
    public void setKey(K key){
       this.key=key;
    }
    @Override
    public String toString(){
       return key+" - "+value;
    }
}
class main{
    public static void main(String[] args){
        Pair<String, Integer> p1 = new Pair<>("Tuổi", 20);
        Pair<String, String> p2 = new Pair<>("Mã SV", "SV001");
        Pair<Integer, Double> p3 = new Pair<>(105, 21.5);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
