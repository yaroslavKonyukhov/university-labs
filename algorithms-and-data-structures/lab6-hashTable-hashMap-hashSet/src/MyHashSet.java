import java.util.ArrayList;

public class MyHashSet<T>{
    private MyHashMap<T, Object> map;

    public MyHashSet(){
        map = new MyHashMap<>();
    }

    public void add(T value)
    {
        map.put(value, null);
    }

    public void remove(T value)
    {
        map.remove(value);
    }

    public boolean contains(T value)
    {
        return map.contains(value);
    }

    @Override
    public String toString() {
        ArrayList<T> values = map.getKeys();
        return values.toString();
    }
}
