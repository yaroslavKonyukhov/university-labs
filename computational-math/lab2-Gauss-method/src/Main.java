import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double[][] arr = {
                {1, 2, 3, 1},
                {2, -1, 2, 6},
                {1, 1, 5, -1}
        };

        for(int i = 0; i < arr.length; i++)
        {
            double x = arr[i][i];

            for(int j = i; j < arr[i].length; j++)
            {
                arr[i][j] /= x;
            }

            if(i == arr.length - 1)
                break;

            for (int f = i+1; f < arr.length; f++)
            {
                double fac = arr[f][i];
                for (int g = i; g < arr[f].length; g++)
                {
                    arr[f][g] -= arr[i][g] * fac;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));

        double[] solutions = new double[arr.length];

        for(int i = arr.length - 1; i >= 0; i--)
        {
            double sum = 0;
            for (int j = i+1; j < arr.length; j++)
            {
                sum += arr[i][j] * solutions[j];
            }

            solutions[i] = arr[i][arr[i].length - 1] - sum;
        }

        for (int i = 0; i < solutions.length; i++) {
            System.out.println("X" + (i + 1) + " = " + solutions[i]);
        }

    }
}