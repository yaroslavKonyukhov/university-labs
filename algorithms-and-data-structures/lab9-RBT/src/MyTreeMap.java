import java.util.ArrayList;
import java.util.List;

public class MyTreeMap<K extends Comparable<K>, V>{

    private class Para implements Comparable<Para>{

        K key;
        V value;

        public Para(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Para o) {
            return this.key.compareTo(o.key);
        }

        @Override
        public String toString() {
            return "(" + key + ":" + value + ")";
        }
    }

    private MyRBT<Para> tree;

    public MyTreeMap(){
        tree = new MyRBT<>();
    }

    public void add(K key, V value){
        tree.add(new Para(key, value));
    }

    public void remove(K key)
    {
        tree.remove(new Para(key, null));
    }

    public List<K> getKeys()
    {
        List<Para> elements = tree.getElements();
        List<K> keys = new ArrayList<>();

        for(Para para : elements){
            keys.add(para.key);
        }
        return keys;
    }

    public List<V> getValues()
    {
        List<Para> elements = tree.getElements();
        List<V> values = new ArrayList<>();

        for(Para para : elements){
            values.add(para.value);
        }
        return values;
    }

    public V get(K key)
    {
        Para p = tree.getElement(new Para(key, null));

        if(p == null)
            return null;
        return tree.getElement(new Para(key, null)).value;
    }

    public boolean contains(K key)
    {
        return tree.contains(new Para(key, null));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        List<Para> list = tree.getElements();

        for(Para p : list){
            sb.append(p.toString() + " ");
        }
        return sb.toString();
    }
}
