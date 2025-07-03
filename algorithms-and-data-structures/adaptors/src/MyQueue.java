import java.util.LinkedList;

public class MyQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();

    public void add(E e){
        list.addLast(e);
    }

    public E remove(){
        return list.removeFirst();
    }

    public E element(){
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }
}
