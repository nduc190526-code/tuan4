package Bai1;

abstract class Shape {
protected int x;
protected int y;
abstract public void erase();
abstract public void draw();
public void  moveTo(int x1,int y1){
    erase();
    x=x1;
    y=y1;
    draw();
}
public Shape (int x,int y){
    this.x=x;
    this.y=y;
    }

}
class Circle extends Shape {
    public Circle(int x,int y){
        super (x,y);
    }
public void draw(){
        System.out.println("Vẽ hình tròn tại ("+x+", "+y+")");
}
public void erase(){
    System.out.println("Xóa hình tròn tại ("+x+", "+y+")");
}
}
class Square extends Shape{
    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình vuông tại (" + x + ", " + y + ")");
    }
}
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}