package Bai6;

public class ArrayUtils {
    public static <T> void swap(T[] array,int i, int j){
        T tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static <T extends Comparable<T>> void sort(T[] array){
        int n= array.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n-i-1;j++){
                if(array[j].compareTo(array[j+1])>0){
                    swap(array,j,j+1);
                }
            }
        }
    }

}
 class Student implements Comparable<Student> {
     private String name;

     public Student(String name) {
         this.name = name;
     }
     @Override
     public int compareTo(Student other) {
         return this.name.compareTo(other.name);
     }
     @Override
     public String toString() {
         return name;
     }
 }
     class main {
         public static <T> void printArray(T[] array) {
             for (T element : array) {
                 System.out.print(element + " ");
             }
         }

         public static void main(String[] args) {
             Integer[] intArray = {5, 1, 3, 2};
             ArrayUtils.sort(intArray);
             printArray(intArray);
             System.out.println();

             String[] strArray = {"Java", "C++", "Python"};
             ArrayUtils.sort(strArray);
             printArray(strArray);
             System.out.println();

             Student[] stdArray = {new Student("Nam"), new Student("An"), new Student("Binh")};
             ArrayUtils.sort(stdArray);
             printArray(stdArray);
         }
     }
