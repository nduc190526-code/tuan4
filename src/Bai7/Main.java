package Bai7;
import Bai7.Student;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

interface Operation<T> {
    T execute(T a, T b);
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();

            Student s = new Student(id, name);
            s.setGpa(gpa);

            students.add(s);
        }

        students.removeIf(s -> s.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        for (Student s : students) {
            System.out.println(
                    s.getId() + " " + s.getName() + " " + s.getGpa()
            );
        }
        System.out.println();
        // Sắp xếp theo tên
        students.sort((s1, s2) ->
                s1.getName().compareTo(s2.getName())
        );

        System.out.println("After sorting by name:");
        for (Student s : students) {
            System.out.println(
                    s.getId() + " " + s.getName() + " " + s.getGpa()
            );
        }
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> a / b;
        sc.close();
    }
}
