public class Main {
    public static void main(String[] args) {
        MyFunc<Double, Double, Double> f = (x, y) -> Math.exp(x * y) - x*x + y - 1.4;
        MyFunc<Double, Double, Double> g = (x, y) -> (x + 0.5)*(x + 0.5) + y*y - 1;
        MyFunc<Double, Double, Double> f1x = (x, y) -> y * Math.exp(x*y) - 2*x;
        MyFunc<Double, Double, Double> f1y = (x, y) -> x*Math.exp(x*y)+1;
        MyFunc<Double, Double, Double> g1x = (x, y) -> 2*(x + 0.5);
        MyFunc<Double, Double, Double> g1y = (x, y) -> 2*y;

        double x0 = 0.419;
        double y0 = 0.395;
        double e = 0.001;

        task(f, g, f1x, f1y, g1x, g1y, x0, y0, e);

        System.out.println();

        MyFunc<Double, Double, Double> f2 = (x, y) -> Math.tan(x*y + 0.4) - x*x;
        MyFunc<Double, Double, Double> g2 = (x, y) -> 0.9*x*x + 2*y*y -1;
        MyFunc<Double, Double, Double> f1x2 = (x, y) -> (1/Math.cos(x*y + 0.4)) * y - 2*x;
        MyFunc<Double, Double, Double> f1y2 = (x, y) -> (1/Math.cos(x*y + 0.4)) * x;
        MyFunc<Double, Double, Double> g1x2 = (x, y) -> 1.8*x;
        MyFunc<Double, Double, Double> g1y2 = (x, y) -> 4*y;

        double x02 = 0.928;
        double y02 = 0.335;
        double e2 = 0.000001;

        task(f2, g2, f1x2, f1y2, g1x2, g1y2, x02, y02, e2);
    }

    public static boolean ok(double a, double b, double e)
    {
        if(Math.abs(a-b) > e)
            return true;
        return false;
    }


    public static void task(MyFunc<Double, Double, Double> f,
                            MyFunc<Double, Double, Double> g,
                            MyFunc<Double, Double, Double> f1x,
                            MyFunc<Double, Double, Double> f1y,
                            MyFunc<Double, Double, Double> g1x,
                            MyFunc<Double, Double, Double> g1y,double x0, double y0, double e)
    {
        double xOld = 0, yOld = 0;
        double xNew = x0, yNew = y0;

        do {
            double j = f1x.apply(xNew, yNew) * g1y.apply(xNew, yNew) - g1x.apply(xNew, yNew) * f1y.apply(xNew, yNew);

            if(Math.abs(j) < 1e-10) {
                System.out.println("Jacobi = 0");
                return;
            }

            double dX = (f.apply(xNew, yNew) * g1y.apply(xNew, yNew) - g.apply(xNew, yNew) * f1y.apply(xNew, yNew))/j;
            double dY = (f1x.apply(xNew, yNew) * g.apply(xNew, yNew) - g1x.apply(xNew, yNew) * f.apply(xNew, yNew))/j;

            xOld = xNew;
            xNew -= dX;

            yOld = yNew;
            yNew -= dY;

        }while (ok(xNew, xOld, e) || ok(yNew, yOld, e));

        System.out.println("X = " + xNew + ", Y = " + yNew);
    }
}