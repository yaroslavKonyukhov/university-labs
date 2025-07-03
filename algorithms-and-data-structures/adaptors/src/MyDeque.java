import java.util.LinkedList;

public class MyDeque<E> {
    private final LinkedList<E> list = new LinkedList<>();

    public void addFirst(E e){
        list.addFirst(e);
    }

    public void addLast(E e){
        list.addLast(e);
    }

    public E removeFirst(){
        return list.removeFirst();
    }

    public E removeLast(){
        return list.removeLast();
    }

    public E getFirst(){
        return list.getFirst();
    }

    public E getLast(){
        return list.getLast();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
