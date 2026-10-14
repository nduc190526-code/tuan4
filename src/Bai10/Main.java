package Bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class MediaItem{
    String id;
    String name;
    public MediaItem(String id,String name){
        this.id=id;
        this.name=name;
    }
    public abstract void display();
}
class Book extends MediaItem{
    String Author;
    int Pagenumber;
    public Book(String id,String name,String Author,int Pagenumber){
        super(id,name);
        this.Author=Author;
        this.Pagenumber=Pagenumber;
    }


    public void display(){
        System.out.println(name +" - "+Author+" - "+Pagenumber);
    }
}
class DVD extends MediaItem{
    String Director;
    int time;
    public DVD (String id,String name,String Director,int time){
        super(id,name);
        this.Director=Director;
        this.time=time;
    }
    public void display(){
        System.out.println(name+" - "+Director+" - "+time);
    }
}
class LibrarySection <T extends MediaItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        for (T item : items) {
            item.display();
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("B")) {
                String author = sc.next();
                int pages = sc.nextInt();

                Book book = new Book(id, name, author, pages);
                bookSection.addItem(book);

            } else if (type.equals("D")) {
                String director = sc.next();
                int duration = sc.nextInt();

                DVD dvd = new DVD(id, name, director, duration);
                dvdSection.addItem(dvd);
            }
        }

        System.out.println("Khu vực Sách:");
        bookSection.displayItems();

        System.out.println();

        System.out.println("Khu vực DVD:");
        dvdSection.displayItems();

        sc.close();
    }
}
