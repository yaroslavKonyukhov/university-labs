import java.util.List;

public class MyTreeSet<K extends Comparable<K>>{

    private MyTreeMap<K, Object> treeMap;

    public MyTreeSet() {
        treeMap = new MyTreeMap<>();
    }

    public void add(K key) {
        treeMap.add(key, null);
    }

    public void remove(K key) {
        treeMap.remove(key);
    }

    public boolean contains(K key) {
        return treeMap.contains(key);
    }

    @Override
    public String toString() {
        List<K> keys = treeMap.getKeys();

        StringBuilder sb = new StringBuilder();

        for (K key : keys) {
            sb.append(key.toString() + " ");
        }
        return sb.toString();
    }
}
