import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    class Node {
        int hash;
        K key;
        V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private int size;
    private static final int capacity = 10;

    private LinkedList<Node>[] arr;

    public MyHashMap() {
        arr = new LinkedList[capacity];
    }

    private void add(LinkedList<Node> data, int ind)
    {
        if(ind >= arr.length || ind < 0)
            throw new IndexOutOfBoundsException();

        size++;
        if(size == arr.length)
            grow();

        arr[ind] = data;
    }

    private void grow()
    {
        int temp = arr.length * 2;
        arr = Arrays.copyOf(arr, temp);

        for(int i = 0; i < arr.length/2; i++)
        {
            LinkedList<Node> list = arr[i];

            arr[i] = null;
            size--;

            for(int j = 0; j < list.size(); j++)
            {
                Node n = list.get(j);
                put(n.key, n.value);
            }
        }
    }

    public void put(K key, V value)
    {
        int hash = key.hashCode();
        int ind = hash % arr.length;

        LinkedList<Node> cur = arr[ind];

        if(cur != null)
        {
            for(int i = 0; i < cur.size(); i++)
            {
                Node n = cur.get(i);
                if(hash == n.hash && key.equals(n.key))
                {
                    n.value = value;
                    return;
                }
            }

            Node newNode = new Node(hash, key, value);
            cur.addFirst(newNode);
        }
        else
        {
            add(new LinkedList<>(), ind);
            Node newNode = new Node(hash, key, value);
            ind = hash % arr.length; 
            if(arr[ind] == null)
                add(new LinkedList<>(), ind);
            arr[ind].addFirst(newNode);
        }
    }

    public V get(K key)
    {
        int hash = key.hashCode();
        int ind = hash % arr.length;

        LinkedList<Node> cur = arr[ind];
        V result = null;

        if(cur != null)
        {
            for (int i = 0; i < cur.size(); i++)
            {
                Node n = cur.get(i);
                if(hash == n.hash && key.equals(n.key))
                    result = n.value;
            }
        }

        return result;
    }

    public void remove(K key)
    {
        int hash = key.hashCode();
        int ind = hash % arr.length;

        LinkedList<Node> cur = arr[ind];

        if(cur != null)
        {
            for (int i = 0; i < cur.size(); i++)
            {
                Node n = cur.get(i);
                if(hash == n.hash && key.equals(n.key))
                {
                    cur.remove(i);
                    if(cur.isEmpty())
                    {
                        arr[ind] = null;
                        size--;
                    }
                }
            }
        }
    }

    public boolean contains(K key)
    {
        boolean result = false;

        int hash = key.hashCode();
        int ind = hash % arr.length;

        LinkedList<Node> cur = arr[ind];

        if(cur != null)
        {
            for (int i = 0; i < cur.size(); i++)
            {
                Node n = cur.get(i);
                if(hash == n.hash && key.equals(n.key))
                    result = true;
            }
        }

        return result;
    }

    public ArrayList<K> getKeys()
    {
        ArrayList<K> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
        {
            LinkedList<Node> cur = arr[i];
            if(cur == null)
                continue;
            for (int j = 0; j < cur.size(); j++)
            {
                Node n = cur.get(j);
                result.add(n.key);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++)
        {
            LinkedList<Node> cur = arr[i];
            if(cur == null)
                continue;
            for(int j = 0; j < cur.size(); j++)
            {
                Node n = cur.get(j);
                sb.append(n + ",");
            }
        }

        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
}
