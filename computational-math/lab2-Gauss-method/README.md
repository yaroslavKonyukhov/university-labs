# Gauss method
- It's used to solve systems of linear algebraic equations.
- We have coefficient matrix A = (aij), right-hand side vector b and vector of unknown x's.
- Determinant of A must not be equal to zero. Otherwise, the system can have either infinitely many solutions or none.
- There are 2 steps:
  1) Direct - we need to get upper triangular matrix where diagonal elements equal to 1.
  2) Inverse - we need to find unknown x's with the help of matrix from the first step.
- For example we have:
- Matrix A and vector B:
 [a11, a12, a13|b1]
 [a21, a22, a23|b2]
 [a31, a32, a33|b3]
- For example first c11 = a11/a11, c12 = a12/a11, c13 = a13/a11, then for each row below a21 - a21*c11, a22 - a21*c12, a23 - a21*c13, the same for third row and then repeat the same process for second row: normalize and eliminate entries below the pivot. But for the last row do only normalization.
- After Direct step:
 [1, c12, c13|d1]
 [0, 1, c23|d2]
 [0, 0, 1|d3]
- Inverse step:
 x3 = d3; x2 = d2 - x3*c23; x1 = d1 - x2*c12 - x3*c13;
