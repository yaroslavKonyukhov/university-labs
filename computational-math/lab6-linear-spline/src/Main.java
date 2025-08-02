public class Main {
    public static void main(String[] args) {
        double[] x = {12, 13, 16};
        double[] y = {9.75, 10.25, 50};
        System.out.println(linearSpline(x, y, 13.6));

        double[] x2 = {11, 12, 13, 15, 16};
        double[] y2 = {9.75, 9, 10.25, 20, 50};
        System.out.println(linearSpline(x2, y2, 12.3));
    }

    public static double linearSpline(double[] x, double[] y, double xToFindY)
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
            throw new IllegalArgumentException("Your X is not in the interval of the Xs");

        double result = y[ind] + ((y[ind+1] - y[ind])/(x[ind+1] - x[ind]))*(xToFindY - x[ind]);
        return result;
    }
}