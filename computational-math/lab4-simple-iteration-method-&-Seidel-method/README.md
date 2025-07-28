# Simple iteration method
- It is used to find x's approximately when solving systems of linear algebraic equations. Therefore, it is not an exact method, but an approximation method.
- We can represent the system of equations as a matrix A and right-hand side vecor b.
- Important requirement: the off-diagonal elements of the matrix in the sum by module must be less than the diagonal element by module. That is, the off-diagonal elements of the matrix in the sum by module divided by the diagonal element by module = C must be strictly less than 1. We save the maximum C as alpha to find deviation in the future.
- The essence of the method is that we iteratively reduce the value of the initial x's to real values, which are the answer. The initial x's can be any. In each iteration, we use the found x's from the previous iteration. We perform iterations until the difference in the x's of the last two iterations by module does not correspond to the permissible error E.
- To find the deviation after finding the answers, we need to find the largest difference between the x's of the last two iterations. Then multiply it by alpha divided by 1-alpha.
- To find x: xi^(k+1) = 1/aii * (bi - sum of aij * xj^(k) where i != j).
# Seidel method
- The Seidel method is identical to the simple iteration method, but in each iteration it uses the already found X's in the current iteration, thereby speeding up the process.
- To find x: xi^(k+1) = 1/aii * (bi - sum of aij * xj^(k+1) (where j = 1,..,i-1) - sum of aij * xj^(k) (where j = i+1,..,n)).
- I was asked to implement Seidel method in code.
