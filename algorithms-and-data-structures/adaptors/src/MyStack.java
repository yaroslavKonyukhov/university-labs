import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<E> {
    private final ArrayList<E> list = new ArrayList<>();

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public E peek(){
        return list.get(list.size()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }
}
