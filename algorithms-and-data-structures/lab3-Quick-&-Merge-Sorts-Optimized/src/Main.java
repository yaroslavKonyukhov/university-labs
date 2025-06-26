import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 8, 1, 4, 7, 3, 6, 9};
        /*
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

         */


        quicksort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int[] b = new int[52];
        Random r = new Random();
        for(int i = 0; i < 52; i++)
        {
            b[i] = r.nextInt(100 - 10) + 10;
        }
        System.out.println(Arrays.toString(b));
        quicksort2(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));



        System.out.println();
        System.out.println("Task2");

        int[] c = new int[52];
        for(int i = 0; i < 52; i++)
        {
            c[i] = r.nextInt(100 - 10) + 10;
        }
        System.out.println(Arrays.toString(c));
        mergesort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }

    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static int partition(int[] a, int start, int end)
    {
        int pivot = a[end];
        int i = start-1;

        for(int j = start; j < end; j++)
        {
            if(a[j] < pivot)
            {
                swap(a, ++i, j);
            }
        }

        swap(a, ++i, end);

        return i;
    }

    public static int[] partition2(int[] a, int start, int end)
    {
        Random random = new Random();
        int p = random.nextInt(end - start) + start;
        //System.out.println(p);
        int[] pInd = new int[]{p, p+1};

        if(a[pInd[1]] < a[pInd[0]])
        {
            swap(a, pInd[0], pInd[1]);
        }

        int i = start-1;
        int[] ind = new int[2];

        for(int h = 0; h < 2; h++)
        {
            for(int j = i+1; j <= end; j++)
            {
                if(a[j] < a[pInd[h]])
                {
                    if(i+1 == pInd[h])
                        pInd[h] = j;
                    if(h == 0 && i+1 == pInd[1])
                        pInd[1] = j;
                    swap(a, ++i, j);
                }
            }

            if(h == 0 && i+1 == pInd[1])
                pInd[1] = pInd[0];
            swap(a, ++i, pInd[h]);
            ind[h] = i;
        }

        return ind;
    }


    public static void quicksort(int[] a, int start, int end)
    {
        if(start < end)
        {
            int i = partition(a, start, end);

            quicksort(a, start, i-1);
            quicksort(a, i+1, end);
        }
    }

    public static void quicksort2(int[] a, int start, int end)
    {
        if(start < end)
        {
            int[] i = partition2(a, start, end);

            quicksort2(a, start, i[0]-1);
            quicksort2(a, i[0]+1, i[1]-1);
            quicksort2(a, i[1]+1, end);
        }
    }

    public static void insertionsort(int[] a, int start, int end)
    {
        for(int i = start+1; i <= end; i++)
        {
            int key = a[i];
            int j = i-1;

            while(j >= start && a[j] > key)
            {
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = key;
        }
    }

    public static void merge(int[] a, int start, int mid, int end)
    {
        int n = mid-start+1;
        int m = end-mid;
        int[] L = new int[n];
        int[] R = new int[m];

        for(int i = 0; i < n; i++)
        {
            L[i] = a[start+i];
        }
        for(int i = 0; i < m; i++)
        {
            R[i] = a[mid+i+1];
        }

        int i = 0, j = 0, k = start;
        while(i < n && j < m)
        {
            a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }

        while(i < n)
            a[k++] = L[i++];
        while(j < m)
            a[k++] = R[j++];
    }


    public static void mergesort(int[] a, int start, int end)
    {
        if(end - start <= 10)
        {
            insertionsort(a, start, end);
            return;
        }

        int mid = start + (end - start)/2;

        mergesort(a, start, mid);
        mergesort(a, mid+1, end);

        merge(a, start, mid, end);
    }


}