import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double[][] arr = {
                {1, 2, 3},
                {2, -1, 2},
                {1, 1, 5}
        };

        for(int i = 1; i < arr.length; i++)
        {
            for(int j = i; j < arr.length; j++)
            {
                double x = arr[j][i-1]/arr[i-1][i-1];

                for(int f = i-1; f < arr[i].length; f++)
                {
                    arr[j][f] -= arr[i-1][f] * x;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));

        double det = 1;
        for(int i = 0; i < arr.length; i++)
        {
            det *= arr[i][i];
        }

        System.out.println(det);


        double[][] aug = new double[arr.length][arr[0].length*2];

        for(int i = 0; i < aug.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                aug[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < aug.length; i++)
        {
            aug[i][aug[i].length/2 + i] = 1;
        }

        System.out.println(Arrays.deepToString(aug));

        for(int i = 0; i < aug.length; i++)
        {
            double x = aug[i][i];

            for(int j = 0; j < aug[i].length; j++)
            {
                aug[i][j] /= x;
            }

            if(i == aug.length-1)
                break;

            for(int f = i+1; f < aug.length; f++)
            {
                double y = aug[f][i];
                for(int g = i; g < aug[f].length; g++)
                {
                    aug[f][g] -= aug[i][g] * y;
                }
            }
        }

        System.out.println(Arrays.deepToString(aug));

        for(int i = aug.length-2; i >= 0; i--)
        {
            for(int j = i; j >= 0; j--)
            {
                double x = aug[j][i+1];

                for(int f = i+1; f < aug[j].length; f++)
                {
                    aug[j][f] -= aug[i+1][f] * x;
                }
            }
        }

        System.out.println(Arrays.deepToString(aug));

        double[][] result = new double[aug.length][aug[0].length/2];

        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result[i].length; j++)
            {
                result[i][j] = aug[i][aug[i].length/2 + j];
            }
        }

        System.out.println(Arrays.deepToString(result));
    }
}