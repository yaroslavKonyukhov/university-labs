# Determinant
- For example we have matrix A and we need to get its determinant det(A). We can use Gauss elimination to transform matrix A into the matrix where all entries under diagonal elements are zeroes. Then by multiplying the diagonal elements we get the determinant. We need to take some rules into account.
 1) Row swapping: changes the sign of the determinant.
 2) Row scaling: multiplying a row by scalar multiplies the determinant by the same scalar.
 3) Row Addition: adding a multiple or one row to another does not change the determinant.
- Formula: det(A) = (-1)^s * multiplied elements uii (i = 1,..,n).
- where: s - number of raw swaps, uii - diagonal elements of matrix U - matrix A after Gauss elimination.
# Inverse matrix
- A * A^(-1) = I
- A * x = b
- To find A^(-1), we form an augmented matrix [A|I] and apply Gauss-Jordan elimination to transform A into I. The right side then becomes A^(-1).
