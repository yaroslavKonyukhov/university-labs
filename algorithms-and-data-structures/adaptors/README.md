# Adaptors
- Adaptors are data structures that provide a convenient interface to more general collections. They are like a wrapper around existing data structures. By limiting the basic data structures, they provide special functionality that is useful in different cases.
## Queue
- Queue (FIFO - First In First Out) - the first added element will be the first to remove. Implemented with the help of LinkedList.
## Stack
- Stack (LIFO - Last In First Out) - the last added element will be the first to remove. Implemented with the help of ArrayList.
## Deque
- Deque (Double ended queue) - element can be added to or removed from both sides. It's universal adaptor. Implemented with the help of LinkedList.

Also there is ability to create stack with the help of two queues or queue with the help of two stacks.

## Stack From two queues
- The idea is to move elements between queues when adding or removing, simulating the order of stack elements 
- There are two approaches: 1) slow push, fast pop (moves elements when adding); 2) slow pop, fast push (moves elements when removing).
## Queue From two stack
- The idea is to use two stacks, moving elements between them, to simulate the order of queue elements.
- There are two approaches: 1) lazy permutation (the most efficient) using "shiftStacks()" method; 2) greedy approach - "add" method is expensive but it provides instant access to the first element.
