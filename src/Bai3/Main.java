package Bai3;
import java.util.ArrayList;
import java.util.Scanner;
interface IWorkable{
    public abstract void work();
}
abstract class Employee implements IWorkable{
    protected String id;
    protected String name;
    protected int baseSalary;
    abstract public double calculatePay();
}
class OfficeWorker extends Employee{
   public double calculatePay(){
       return baseSalary;
   }
    public void work(){
       System.out.println("Soạn thảo văn bản");
    }
}
class Technician extends Employee{
    public int overtimeHours;
    public double calculatePay(){
        return baseSalary+overtimeHours*20000;
    }
    public void work(){
        System.out.println("Lắp đặt thiết bị");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soLuong = sc.nextInt();

        ArrayList<Employee> danhSachNV = new ArrayList<>();

        for (int i = 0; i < soLuong; i++) {
            String loaiNV = sc.next();
            String maNV = sc.next();
            String tenNV = sc.next();
            int luongCoBan = sc.nextInt();

            if (loaiNV.equals("O")) {
                OfficeWorker nvVP = new OfficeWorker();
                nvVP.id = maNV;
                nvVP.name = tenNV;
                nvVP.baseSalary = luongCoBan;

                danhSachNV.add(nvVP);

            } else if (loaiNV.equals("T")) {
                int gioLamThem = sc.nextInt();

                Technician nvKT = new Technician();
                nvKT.id = maNV;
                nvKT.name = tenNV;
                nvKT.baseSalary = luongCoBan;
                nvKT.overtimeHours = gioLamThem;

                danhSachNV.add(nvKT);
            }
        }

        for (Employee nv : danhSachNV) {
            System.out.println(nv.name + " - Pay: " + nv.calculatePay());
            nv.work();
            System.out.println();
        }
    }
}

