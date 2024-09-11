import java.util.Scanner;
public class task2 {
    static int sum=0;
    static int avg=0;
    public static void main(String[] args) {
        try(Scanner sub = new Scanner(System.in)) {
        System.out.println("Enter how many subjects");
        int n = sub.nextInt();
        try(Scanner Obj = new Scanner(System.in)) {
        int marks[] = new int[n];
        System.out.println("Enter each subject marks(out of 100):");
        for (int i = 0; i < n; i++) {
            marks[i] = Obj.nextInt();
        }
            for (int i = 0; i < n; i++) {
                sum = sum + marks[i];
            }
            avg = sum / n;
            System.out.println("total_marks:"+sum);
            System.out.println("percentage:"+avg);
        if (avg>90) {
            System.out.println("Grade A");
        }
        else if (avg>80) {
            System.out.println("Grade B");
        }
        else if (avg>70) {
            System.out.println("Grade C");
        }
        else if (avg>60) {
            System.out.println("Grade D");
        }
        else if (avg>50) {
            System.out.println("Grade E");
        }
        else {
            System.out.println("Grade F");
        }
        }}
    }
}