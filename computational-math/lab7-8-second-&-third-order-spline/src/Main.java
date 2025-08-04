import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {

        /*
        double[] x1 = {12, 13, 16};
        double[] y1 = {9.75, 10.25, 50};
        System.out.println(universalSpline(x1, y1, 13.6, 1));

        double[] x = {1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5};
        double[] y = {0.89121, 0.93204, 0.96356, 0.98545, 0.99749, 0.99957, 0.99166, 0.97385, 0.94630, 0.90930, 0.86321, 0.80850, 0.74571, 0.67546, 0.59847};
        System.out.println(universalSpline(x, y, 2.031, 2));
        System.out.println(R(x, y, 2.031, 2));

        System.out.println();

        double[] betweenX = {1.151, 1.218, 1.345, 1.421, 1.538, 1.609, 1.732, 1.849, 1.929, 2.031, 2.173, 2.218, 2.313, 2.437, 2.478};

        ArrayList<Double> allX = new ArrayList<>();
        ArrayList<Double> allY = new ArrayList<>();

        for(double v : x)
            allX.add(v);
        for(double v : betweenX)
            allX.add(v);

        Collections.sort(allX);

        for (double v : allX)
            allY.add(universalSpline(x, y, v, 2));

        for (int i = 0; i < allX.size(); i++)
            System.out.println("(" + allX.get(i) + ", " + allY.get(i) + ")");

         */

        double[] xF = {1.5, 1.51, 1.52, 1.53, 1.54, 1.55, 1.56, 1.57, 1.58, 1.59, 1.60};
        double[] yF = {0.51183, 0.50624, 0.50064, 0.49503, 0.48940, 0.48376, 0.47811, 0.47245, 0.46678, 0.46110, 0.45540};
        double[] XToFindYF = {1.50911, 1.50820, 1.50253, 1.50192, 1.59513, 1.59575, 1.59614, 1.59728};

        double[] xG = {1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yG = {0.5652, 0.6375, 0.7147, 0.7973, 0.8861, 0.9817, 1.0848, 1.1964, 1.3172, 1.4482, 1.5906};
        double[] XToFindYG = {1.0113, 1.0219, 1.0321, 1.0428, 1.9592, 1.9675, 1.9728, 1.9819};

        double[] xH = {0, 0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.50};
        double[] yH = {0.28081, 0.31270, 0.34549, 0.37904, 0.41318, 0.44774, 0.48255, 0.51745, 0.55226, 0.58682, 0.62096};
        double[] XToFindYH = {0.01928, 0.01392, 0.02475, 0.02713, 0.47113, 0.47531, 0.48398, 0.48675};

        //For F
        ArrayList<Double> allXF = new ArrayList<>();
        ArrayList<Double> allYF = new ArrayList<>();

        for(double x : xF)
            allXF.add(x);
        for(double x : XToFindYF)
            allXF.add(x);

        Collections.sort(allXF);

        for(double x : allXF)
            allYF.add(universalSpline(xF, yF, x, 3));

        //For G
        ArrayList<Double> allXG = new ArrayList<>();
        ArrayList<Double> allYG = new ArrayList<>();

        for(double x : xG)
            allXG.add(x);
        for(double x : XToFindYG)
            allXG.add(x);

        Collections.sort(allXG);

        for(double x : allXG)
            allYG.add(universalSpline(xG, yG, x, 3));

        //For H
        ArrayList<Double> allXH = new ArrayList<>();
        ArrayList<Double> allYH = new ArrayList<>();

        for(double x : xH)
            allXH.add(x);
        for(double x : XToFindYH)
            allXH.add(x);

        Collections.sort(allXH);

        for(double x : allXH)
            allYH.add(universalSpline(xH, yH, x, 3));

        //Result

        System.out.println("For F:");
        for(int i = 0; i < allXF.size(); i++)
            System.out.print("(" + allXF.get(i) + "," + allYF.get(i) + ") ");
        System.out.println();
        System.out.println("For G:");
        for(int i = 0; i < allXG.size(); i++)
            System.out.print("(" + allXG.get(i) + "," + allYG.get(i) + ") ");
        System.out.println();
        System.out.println("For H:");
        for(int i = 0; i < allXH.size(); i++)
            System.out.print("(" + allXH.get(i) + "," + allYH.get(i) + ") ");

    }

    public static double universalSpline(double[] x, double[] y, double xToFindY, int n)
    {
        int ind = -1;

        for(int i = 0; i < x.length-1; i++)
        {
            if(xToFindY >= x[i] && xToFindY <= x[i+1])
            {
                ind = i;
                break;
            }
        }

        if(ind == -1)
            throw new IllegalArgumentException();

        double[][] delY = new double[n][n];

        double result = 0;
        if(xToFindY - x[0] <= x[x.length-1] - xToFindY)
        {
            if(ind + n + 1 > y.length)
                throw new IllegalArgumentException();

            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n-i; j++)
                {
                    if(i == 0) {
                        delY[j][i] = y[ind + j + 1] - y[ind + j];
                    } else {
                        delY[j][i] = delY[j+1][i-1] - delY[j][i-1];
                    }
                }
            }

            double q = (xToFindY - x[ind])/(x[ind+1] - x[ind]);
            double qs = 1;
            double fac = 1;

            result += y[ind];
            for(int i = 1; i <= n; i++)
            {
                qs *= (q - (i - 1));
                fac *= i;

                result += (qs * delY[0][i-1]) / fac;
            }
        }else
        {
            if(ind - n + 1 < 0)
                throw new IllegalArgumentException();

            int u = ind - n + 1;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n-i; j++)
                {
                    if(i == 0) {
                        delY[j][i] = y[u + j + 1] - y[u + j];
                    } else {
                        delY[j][i] = delY[j+1][i-1] - delY[j][i-1];
                    }
                }
            }

            double q = (xToFindY - x[ind+1])/(x[ind+1] - x[ind]);
            double qs = 1;
            double fac = 1;

            result += y[ind+1];
            for(int i = 1; i <= n; i++)
            {
                qs *= (q + (i - 1));
                fac *= i;

                result += (qs * delY[n-i][i-1]) / fac;
            }
        }
        return result;
    }


    public static double R(double[] x, double[] y, double xToFindY, int n)
    {
        int ind = -1;
        n++;

        for(int i = 0; i < x.length-1; i++)
        {
            if(xToFindY >= x[i] && xToFindY <= x[i+1])
            {
                ind = i;
                break;
            }
        }

        if(ind == -1)
            throw new IllegalArgumentException();

        double[][] delY = new double[n][n];

        double result = 0;
        if(xToFindY - x[0] <= x[x.length-1] - xToFindY)
        {
            if(ind + n + 1 > y.length)
                throw new IllegalArgumentException();

            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n-i; j++)
                {
                    if(i == 0) {
                        delY[j][i] = y[ind + j + 1] - y[ind + j];
                    } else {
                        delY[j][i] = delY[j+1][i-1] - delY[j][i-1];
                    }
                }
            }

            double q = (xToFindY - x[ind])/(x[ind+1] - x[ind]);
            double fac = 1;
            for(int i = 1; i <= n; i++)
                fac *= i;
            result = delY[0][n-1]/fac;

            for(int i = 1; i <= n; i++)
                result *= (q - (i - 1));
        }else
        {
            if(ind - n + 1 < 0)
                throw new IllegalArgumentException();

            int u = ind - n + 1;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n-i; j++)
                {
                    if(i == 0) {
                        delY[j][i] = y[u + j + 1] - y[u + j];
                    } else {
                        delY[j][i] = delY[j+1][i-1] - delY[j][i-1];
                    }
                }
            }

            double q = (xToFindY - x[ind+1])/(x[ind+1] - x[ind]);
            double fac = 1;
            for(int i = 1; i <= n; i++)
                fac *= i;
            result = delY[0][n-1]/fac;
            for(int i = 1; i <= n; i++)
                result *= (q + (i - 1));
        }
        return Math.abs(result);
    }

}