# Method of square roots
- It's used to solve systems of algebraic linear equations.
- Requirements: matrix must be symetric, positive defined.
- A * x = b
- A = T * T'
- T - upper triangular matrix
- A * x = b -> T * T' * x = b
- Solving by 2 steps:
  1) T' * y = b - forward sustitution
  2) T * x = y - back sustitution
- filling T:
- diagonal elements: tii = sqrt(aii - sum of t^2ki (where k = 1,..., i-1))
- off. diagonal elements: tij = 1/tii * (aij - sum of tki * tkj (where k = 1,...,i-1)).
- I was asked also to adapt the algorithm to work with complex numbers. So I do it in "task2" method.
