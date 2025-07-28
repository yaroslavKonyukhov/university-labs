import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] a = {
                {4, 0.24, -0.08, 0.16},
                {0.09, 3, -0.15, -0.12},
                {0.04, -0.08, 4, 0.06},
                {0.02, 0.06, 0.04, -10}
        };

        double[][] b = {
                {8},
                {9},
                {20},
                {1}
        };

        double e = 0.0005;

        task(a, b, e);

        System.out.println();

        double[][] a5 = {
                {24.41, 2.42, 3.85},
                {2.31, 31.49, 1.52},
                {3.49, 4.85, 28.92}
        };

        double[][] b5 = {
                {30.24},
                {40.35},
                {42.81}
        };

        double e5 = 0.0001;

        task(a5, b5, e5);
    }

    public static boolean ok(double[] a, double[] b, double e)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(Math.abs(a[i]-b[i]) > e)
                return true;
        }
        return false;
    }

    public static double cMax(double[][] a)
    {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            double sum = 0;
            for (int j = 0; j < a[i].length; j++)
            {
                if(i == j)
                    continue;
                sum += a[i][j];
            }
            c[i] = sum/a[i][i];

            if(c[i] >= 1)
                throw new IllegalArgumentException("No convergence");
        }

        return Arrays.stream(c).max().getAsDouble();
    }

    public static void task(double[][] a, double[][] b, double e)
    {
        double alfa = 0;
        try{
            alfa = cMax(a);
        }catch (IllegalArgumentException e1)
        {
            System.out.println(e1.getMessage());
            return;
        }

        double[] xOld = new double[a.length];
        double[] xNew = new double[a.length];
        
        do
        {
            for(int i = 0; i < a.length; i++)
            {
                double sum = 0;
                for(int j = 0; j < a[i].length; j++)
                {
                    if(j == i)
                        continue;
                    sum += a[i][j] * xNew[j];
                }

                xOld[i] = xNew[i];
                xNew[i] = (b[i][0] - sum) / a[i][i];
            }

        }while (ok(xNew, xOld, e));

        double o = Math.abs(xNew[0] - xOld[0]);
        for (int i = 1; i < xNew.length; i++)
        {
            double g = Math.abs(xNew[i] - xOld[i]);
            if(g > o)
                o = g;
        }

        double deviation = alfa/(1-alfa) * o;

        System.out.println("Deviation = " + deviation);

        System.out.println(Arrays.toString(xNew));
    }

}
