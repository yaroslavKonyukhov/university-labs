import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[100];
        int[] c = new int[100];

        Random random = new Random();

        for(int i = 0; i < a.length; i++)
        {
            a[i] = random.nextInt(100) + 1;
            b[i] = random.nextInt(100) + 1;
            c[i] = random.nextInt(100) + 1;

        }

        System.out.println(Arrays.toString(a));
        bucketsort(a);
        System.out.println(Arrays.toString(a));

        System.out.println();

        System.out.println(Arrays.toString(b));
        countingsort(b);
        System.out.println(Arrays.toString(b));

        System.out.println();
        c[0] = 100112;
        c[1] = 38712;
        System.out.println(Arrays.toString(c));
        radixsort(c);
        System.out.println(Arrays.toString(c));
    }

    public static void insertionsort(ArrayList<Integer> a)
    {
        for(int i = 1; i < a.size(); i++)
        {
            int key = a.get(i);
            int j = i-1;

            while(j >= 0 && a.get(j) > key)
            {
                a.set(j + 1, a.get(j));
                j--;
            }

            a.set(j + 1, key);
        }
    }


    public static void bucketsort(int[] a)
    {
        ArrayList<Integer>[] buckets = new ArrayList[11];

        for(int i = 0; i < 11; i++)
            buckets[i] = new ArrayList<>();

        for(int x : a)
            buckets[x/10].add(x);

        int k = 0;
        for(int i = 0; i < 11; i++)
        {
            insertionsort(buckets[i]);
            for(int x : buckets[i])
                a[k++] = x;
        }
    }

    public static void countingsort(int[] a)
    {
        int max = Arrays.stream(a).max().getAsInt();
        int[] count = new int[max+1];
        int[] out = new int[a.length];

        for(int x : a)
            count[x]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        for(int i = a.length-1; i >= 0; i--)
        {
            out[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }

        for (int i = 0; i < out.length; i++)
            a[i] = out[i];
    }

    public static void countingsort(int[] a, int n)
    {
        int[] count = new int[10];
        int[] out = new int[a.length];

        for(int x : a)
            count[(x/n)%10]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        for(int i = a.length-1; i >= 0; i--)
        {
            out[count[(a[i]/n)%10]-1] = a[i];
            count[(a[i]/n)%10]--;
        }

        for (int i = 0; i < out.length; i++)
            a[i] = out[i];
    }

    public static void radixsort(int[] a)
    {
        int max = Arrays.stream(a).max().getAsInt();

        for(int i = 1; max/i != 0; i*=10)
        {
            countingsort(a, i);
        }
    }

}