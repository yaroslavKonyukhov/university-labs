# Bitwise Operators

Bitwise operators - are operators that perform operations on the individual bits of integer results. They work only with byte, short, int, and long types.

## Bitwise operators: 
- & (AND): 1 if two are 1
- | (OR): 0 if two are 0
- ~ (NOT): change 1 -> 0, 0 -> 1
- ^ (XOR): 1 if both are different
- << shift left: move every bit-value to left and ads 0 from right side
- ">>" shift right (signed): move every bit-value to right, preserving the sign (copies the most significant bit)
- ">>>" shift right without preserving sign: move every bit-value to right, filling with zeros on the left.

## Advantage of using bitwise operators - high execution speed:
- Bitwise operations are processed at the processor level and are executed much faster than regular arithmetic or logical operations.

## Task 1
- raise a number a to the power b.
## Task 2
- find all subsets of numbers whose sum gives the target.
## Task 3
- find one unique number. Array stores numbers where only one number is unique and others are equal to each other in pairs.
## Task 4
- the same as task 3 but we have two unique numbers. So we need to find them.
## Task 5
- Not connected with the topic of "Bitwise Operators". It was additional task to lab1: solve fibonacci with O(logn). Such approach is called "Matrix Exponentiation Method for Solving Linear Recurrences". So ussualy we have O(2^n) (if we use recursive algorithm) or O(n) (iterative algorithm) time complexity for solving fibonacci: F(n) = F(n-1) + F(n-2). That's not efficient if we want to find, for example, fibonacci for n = 100. So then we can use linear algebra. Theory: we have two matrixes a = ((1, 0)) and b = ((1, 1), (1, 0)). If we raise matrix b to the power n-1 and multiply matrix a by matrix b^(n-1), then as the first element we will get fibonacci value for n.  


