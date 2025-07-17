import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter a" + i + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter e: ");

        int e = sc.nextInt();

        int result = arr[0];

        for (int i = 1; i < n; i++)
        {
            result = arr[i] + result * e;
        }

        System.out.println("Result: " + result);

    }
}