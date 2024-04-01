import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        System.out.println(input > 0 ? "Positive" : (input < 0) ? "Negative" : "Zero");
        
        sc.close();
    }
}

