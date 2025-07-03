public class QueueFromStack<E> {
    private MyStack<E> in = new MyStack<>();
    private MyStack<E> out = new MyStack<>();

    public void add(E e) {
        in.push(e);
    }

    public E remove(){
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        shiftStacks();
        return out.pop();
    }

    public E element(){
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        shiftStacks();
        return out.peek();
    }

    private void shiftStacks()
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
    }

    public boolean isEmpty()
    {
        return in.isEmpty() && out.isEmpty();
    }

    /*
    public void add(E e) {
        while(!out.isEmpty())
        {
            in.push(out.pop());
        }

        out.push(e);

        while(!in.isEmpty())
        {
            out.push(in.pop());
        }
    }

    public E remove(){
        return out.pop();
    }

    public E element(){
        return out.peek();
    }

     */
}
