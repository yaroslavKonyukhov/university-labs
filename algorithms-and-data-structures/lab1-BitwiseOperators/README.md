# Bitwise Operators

Bitwise operators - are operators that perform operations on the individual bits of integer results. They work only with byte, short, int, and long types.

## Bitwise operators: 
- & (AND): 1 if two are 1
- | (OR): 0 if two are 0
- ~ (NOT): change 1 -> 0, 0 -> 1
- ^ (XOR): 1 if both are different
- << shift left: move every bit-value to left and ads 0 from right side
- >> shift right (signed): move every bit-value to right, preserving the sign (copies the most significant bit)
- >>> shift right without preserving sign: move every bit-value to right, filling with zeros on the left.

Advantage of using bitwise operators - high execution speed:
- Bitwise operations are processed at the processor level and are executed much faster than regular arithmetic or logical operations.



