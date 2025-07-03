public class StackFromQueue<E>{
    private MyQueue<E> q1 = new MyQueue<>();
    private MyQueue<E> q2 = new MyQueue<>();


    public void push(E e){
        q2.add(e);

        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        MyQueue<E> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public E pop(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.remove();
    }

    public E peek(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.element();
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }

    /*

    public void push(E e){
        q1.add(e);
    }

    public E pop(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");

        while(q1.size() > 1)
        {
            q2.add(q1.remove());
        }

        E e = q1.remove();

        MyQueue<E> temp = q2;
        q2 = q1;
        q1 = temp;

        return e;
    }

    public E peek(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");

        while(q1.size() > 1)
        {
            q2.add(q1.remove());
        }

        E e = q1.remove();
        q2.add(e);

        MyQueue<E> temp = q2;
        q2 = q1;
        q1 = temp;

        return e;
    }

     */
}
