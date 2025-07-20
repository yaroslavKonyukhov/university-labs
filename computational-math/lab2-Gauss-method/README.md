# Gauss method
- It's used to solve systems of linear algebraic equations.
- We have matrix of coefficients A = (aij), vector of free members b and vector of unknown x's.
- Determinant of A must not be equal to zero. Otherwise, there is no single solution.
- There are 2 steps:
  1) Direct - we need to get upper triangular matrix where diagonal elements equal to 1.
  2) Inverse - we need to find unknown x's with the help of matrix from the first step.
- For example we have:
- Matrix A and vector B:
 [a11, a12, a13|b1]
 [a21, a22, a23|b2]
 [a31, a32, a33|b3]
- For each row first: mij = aij/aii; then second step for rows below: aij = aij - mij * aii. That is applied fo b. For last row we do only first step.
- After Direct step:
 [1, c12, c13|d1]
 [0, 1, c23|d2]
 [0, 0, 1|d3]
- Inverse step:
 x3 = d3; x2 = d2 - x3*c23; x1 = d1 - x2*c12 - x3*c13;
