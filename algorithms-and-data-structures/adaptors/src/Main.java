public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println();

        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.element());
        System.out.println(queue.remove());

        System.out.println();

        MyDeque<Integer> deque = new MyDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        System.out.println();

        StackFromQueue<Integer> stackFromQ = new StackFromQueue<>();
        stackFromQ.push(1);
        stackFromQ.push(2);
        stackFromQ.push(3);
        System.out.println(stackFromQ.pop());
        System.out.println(stackFromQ.isEmpty());
        System.out.println(stackFromQ.peek());

        System.out.println();

        QueueFromStack<Integer> queueFromS = new QueueFromStack<>();
        queueFromS.add(1);
        queueFromS.add(2);
        queueFromS.add(3);
        System.out.println(queueFromS.element());
        System.out.println(queueFromS.remove());
    }
}