import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("First task:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = 1;

        while(b != 0)
        {
            if((b & (1 << 0)) != 0)
            {
                result *= a;
            }

            a *= a;
            b >>=1;
        }

        System.out.println("Result: " + result);

        System.out.println();

        System.out.println("Second task:");

        int[] arr = {5, -5, 1, 0, 7};

        int target = sc.nextInt();

        for(int i = 1; i < (1 << arr.length); i++)
        {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            sb.append("{");
            boolean first = true;
            for(int j = 0; j < arr.length; j++)
            {
                if((i & (1 << j)) != 0)
                {
                    if(!first)
                        sb.append(", ");

                    first = false;

                    sum += arr[j];
                    sb.append(arr[j]);
                }
            }
            sb.append("}");

            if(sum == target)
                System.out.println(sb);
        }

        System.out.println();
        System.out.println("Task 3");

        int[] arr3 = {1, 4, 1, 5, 4};
        int res = 0;

        for (int x : arr3)
        {
            res ^= x;
        }

        System.out.println("Result: " + res);

        System.out.println();
        System.out.println("Task 4");

        int[] arr4 = {1, 1, 3, 5, 3, 4};
        int res4 = 0;

        for (int x : arr4)
        {
            res4 ^= x;
        }

        int bit = res4 & -res4;

        int u1 = 0;
        int u2 = 0;

        for(int x : arr4)
        {
            if((x & bit) == 0)
            {
                u1 ^= x;
            }
            else {
                u2 ^= x;
            }
        }

        System.out.println("Result: " + u1 + " & " + u2);

        /*
        double[][] arr1 = {
                {-2, 1},
                {5, 4}
        };

        double[][] arr2 = {
                {3},
                {-1}
        };

        System.out.println(Arrays.deepToString(matrixMultiply(arr1, arr2)));
        System.out.println(Arrays.deepToString(matrixPower(arr1, 7)));
        System.out.println(Arrays.deepToString(matrixPower(arr1, 0)));
         */

        System.out.println();
        System.out.println("Task 5");
        System.out.println(fibonachi(19));
    }

    public static double[][] matrixMultiply(double[][] arr1, double[][] arr2)
    {
        if(arr1[0].length != arr2.length)
            throw new IllegalArgumentException("Matrixs can't be multiplied");

        double[][] result = new double[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr2[0].length; j++)
            {
                double sum = 0;

                for (int f = 0; f < arr2.length; f++)
                {
                    sum += arr1[i][f] * arr2[f][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }

    public static double[][] matrixPower(double[][] arr, int n)
    {
        if(arr.length != arr[0].length)
            throw new IllegalArgumentException("Matrix must be quadratic");

        if(n == 0)
        {
            double[][] arr1 = new double[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++)
            {
                arr1[i][i] = 1;
            }
            return arr1;
        }

        if((n & 1) == 0)
        {
            double[][] temp = matrixPower(arr, n/2);
            return matrixMultiply(temp, temp);
        }
        else {
            return matrixMultiply(arr, matrixPower(arr, n-1));
        }
    }

    public static double fibonachi(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }

        double[][] a = {
                {1, 0}
        };

        double[][] b = {
                {1, 1},
                {1, 0}
        };

        double[][] c = matrixPower(b, n-1);
        double[][] result = matrixMultiply(a, c);

        return result[0][0];
    }


}