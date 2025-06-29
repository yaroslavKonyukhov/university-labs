import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {5, 2, 9, 4, 7, 1, 3, 6, 8};
        heapsort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void heapify(int[] a, int n, int i)
    {
        int largest = i;
        int left = i*2+1;
        int right = left+1;

        if(left < n && a[left] > a[largest])
            largest = left;
        if(right < n && a[right] > a[largest])
            largest = right;

        if(largest != i)
        {
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }


    public static void heapsort(int[] a)
    {
        int n = a.length;
        for(int i = n/2-1; i >= 0; i--)
        {
            heapify(a, n, i);
        }

        for(int i = n-1; i > 0; i--)
        {
            swap(a, i, 0);
            heapify(a, i, 0);
        }
    }

}