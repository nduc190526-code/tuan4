package Bai9;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void display();
}

class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println(name + " - " + expiryDate);
    }
}

// Đồ điện tử
class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void display() {
        System.out.println(name + " - " + warrantyMonths + " tháng bảo hành");
    }
}

// Kho hàng dùng Generics
class Warehouse<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void importProduct(T product) {
        products.add(product);
    }

    public void exportProduct(T product) {
        products.remove(product);
    }

    public void inventory() {
        for (T product : products) {
            product.display();
        }
    }
}

// Chương trình chính
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronic> electronicWarehouse = new Warehouse<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String expiryDate = sc.next();
                Food food = new Food(id, name, expiryDate);
                foodWarehouse.importProduct(food);
            } else if (type.equals("E")) {
                int warrantyMonths = sc.nextInt();
                Electronic electronic =
                        new Electronic(id, name, warrantyMonths);
                electronicWarehouse.importProduct(electronic);
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.inventory();

        System.out.println();

        System.out.println("Kho Điện tử:");
        electronicWarehouse.inventory();

        sc.close();
    }
}

