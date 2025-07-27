import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] a = {
                {3.1, 1.5, 1.0},
                {1.5, 2.5, 0.5},
                {1.0, 0.5, 4.2}
        };
        double[][] b = {
                {10.83},
                {9.20},
                {17.10}
        };

        double[][] a2 = {
                {1, 3, -2, 0, -2},
                {3, 4, -5, 1, -3},
                {-2, -5, 3, -2, 2},
                {0, 1, -2, 5, 3},
                {-2, -3, 2, 3, 4}
        };
        double[][] b2 = {
                {0.5},
                {5.4},
                {5.0},
                {7.5},
                {3.3}
        };

        double[][] a3 = {
                {1, 0.42, 0.54, 0.66},
                {0.42, 1, 0.32, 0.44},
                {0.54, 0.32, 1, 0.22},
                {0.66, 0.44, 0.22, 1}
        };
        double[][] b3 = {
                {0.3},
                {0.5},
                {0.7},
                {0.9}
        };

        double[][] a4 = {
                {2.12, 0.42, 1.34, 0.88},
                {0.42, 3.95, 1.87, 0.43},
                {1.34, 1.87, 2.98, 0.46},
                {0.88, 0.43, 0.46, 4.44}
        };
        double[][] b4 = {
                {11.172},
                {0.115},
                {9.009},
                {9.349}
        };

        double[][] a5 = {
                {5.43, 1.12, 0.95, 1.32, 0.83},
                {1.12, 4.03, 2.12, 0.57, 0.91},
                {0.95, 2.12, 6.38, 1.29, 1.57},
                {1.32, 0.57, 1.29, 4.32, 1.25},
                {0.83, 0.91, 1.57, 1.25, 5.46}
        };
        double[][] b5 = {
                {7.24},
                {3.21},
                {3.23},
                {6.25},
                {6}
        };

        task(a, b);
        System.out.println();
        System.out.println();
        task2(a2, b2);
        System.out.println();
        System.out.println();
        task2(a4, b4);
        System.out.println();
        System.out.println();
        task2(a5, b5);

        System.out.println();
        System.out.println(Arrays.toString(sqrt(new double[]{1, -1})));
        System.out.println(Arrays.toString(add(new double[]{1, -1}, new double[]{2, -3.14})));
        System.out.println(Arrays.toString(subtract(new double[]{1, -1}, new double[]{2, -3.14})));
        System.out.println(Arrays.toString(multiply(new double[]{1, -1}, new double[]{2, -3.14})));
        System.out.println(Arrays.toString(divide(new double[]{1, -1}, new double[]{2, -3.14})));

    }

    public static void task(double[][] a, double[][] b)
    {
        double[][] t = new double[a.length][a[0].length];
        double[][] t1 = new double[a.length][a[0].length];

        for(int i = 0; i < a.length; i++)
        {
            double sum = 0;
            for(int j = i; j > 0; j--)
            {
                sum += t[j-1][i] * t[j-1][i];
            }
            double x = Math.sqrt(a[i][i] - sum);
            t[i][i] = x;

            for(int j = i+1; j < a[i].length; j++)
            {
                double sum2 = 0;
                for(int g = i; g > 0; g--)
                {
                    sum2 += t[g-1][j-1] * t[g-1][j];
                }
                t[i][j] = (a[i][j] - sum2) / x;
            }
        }

        for(int i = 0; i < t.length; i++)
        {
            t1[i][i] = t[i][i];
        }
        for(int i = 0; i < t.length; i++)
        {
            for(int j = i+1; j < t[i].length; j++)
            {
                t1[j][i] = t[i][j];
            }
        }

        System.out.println("T: " + Arrays.deepToString(t));
        System.out.println("T1: " + Arrays.deepToString(t1));

        double[] y = new double[t1.length];

        for(int i = 0; i < t1.length; i++)
        {
            double sum = 0;
            for(int j = 0; j < i; j++)
            {
                sum += t1[i][j] * y[j];
            }

            y[i] = (b[i][0] - sum) / t1[i][i];
        }

        System.out.println("Y: " + Arrays.toString(y));

        double[] x = new double[t.length];

        for(int i = t.length - 1; i >= 0; i--)
        {
            double sum = 0;
            for(int j = i+1; j < t[i].length; j++)
            {
                sum += t[i][j] * x[j];
            }

            x[i] = (y[i] - sum) / t[i][i];
        }

        System.out.println("X: " + Arrays.toString(x));
    }

    public static void task2(double[][] a, double[][] b)
    {
        double[][][] t = new double[a.length][a[0].length][2];
        double[][][] t1 = new double[a.length][a[0].length][2];

        for(int i = 0; i < a.length; i++)
        {
            double[] sum = {0, 0};
            for(int j = i; j > 0; j--)
            {
                sum = add(sum, multiply(t[j-1][i],t[j-1][i]));
            }
            double[] x = sqrt(subtract(new double[]{a[i][i], 0}, sum));
            t[i][i] = x;

            for(int j = i+1; j < a[i].length; j++)
            {
                double[] sum2 = {0, 0};
                for(int g = i; g > 0; g--)
                {
                    sum2 = add(sum2, multiply(t[g-1][j-1], t[g-1][j]));
                }
                t[i][j] = divide(subtract(new double[]{a[i][j], 0}, sum2), x);
            }
        }

        for(int i = 0; i < t.length; i++)
        {
            t1[i][i] = t[i][i];
        }
        for(int i = 0; i < t.length; i++)
        {
            for(int j = i+1; j < t[i].length; j++)
            {
                t1[j][i] = t[i][j];
            }
        }

        System.out.println("T: " + Arrays.deepToString(t));
        System.out.println("T1: " + Arrays.deepToString(t1));

        double[][] y = new double[t1.length][2];

        for(int i = 0; i < t1.length; i++)
        {
            double[] sum = {0, 0};
            for(int j = 0; j < i; j++)
            {
                sum = add(sum, multiply(t1[i][j],y[j]));
            }

            y[i] = divide(subtract(new double[]{b[i][0],0}, sum), t1[i][i]);
        }

        System.out.println("Y: " + Arrays.deepToString(y));

        double[][] x = new double[t.length][2];

        for(int i = t.length - 1; i >= 0; i--)
        {
            double[] sum = {0, 0};
            for(int j = i+1; j < t[i].length; j++)
            {
                sum = add(sum, multiply(t[i][j],x[j]));
            }

            x[i] = divide(subtract(y[i], sum),t[i][i]);
        }

        System.out.println("X: " + Arrays.deepToString(x));
    }

    public static double[] add(double[] a, double[] b) {
        double realPart = a[0] + b[0];
        double imaginaryPart = a[1] + b[1];
        return new double[] {realPart, imaginaryPart};
    }

    public static double[] subtract(double[] a, double[] b) {
        double realPart = a[0] - b[0];
        double imaginaryPart = a[1] - b[1];
        return new double[] {realPart, imaginaryPart};
    }

    public static double[] multiply(double[] a, double[] b) {
        double realPart = a[0] * b[0] - a[1] * b[1];
        double imaginaryPart = a[0] * b[1] + a[1] * b[0];
        return new double[] {realPart, imaginaryPart};
    }

    public static double[] divide(double[] a, double[] b) {
        double denominator = b[0] * b[0] + b[1] * b[1];
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double realPart = (a[0] * b[0] + a[1] * b[1]) / denominator;
        double imaginaryPart = (a[1] * b[0] - a[0] * b[1]) / denominator;
        return new double[] {realPart, imaginaryPart};
    }

    public static double[] sqrt(double[] a) {
        double modulus = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
        double realPart = Math.sqrt((modulus + a[0]) / 2);
        double imaginaryPart = Math.sqrt((modulus - a[0]) / 2);
        if (a[1] < 0) {
            imaginaryPart = -imaginaryPart;
        }
        return new double[] {realPart, imaginaryPart};
    }

    public static String toString(double[] complex) {
        return complex[1] >= 0 ? (complex[0] + " + " + complex[1] + "i") : (complex[0] + " - " + (-complex[1]) + "i");
    }

}
