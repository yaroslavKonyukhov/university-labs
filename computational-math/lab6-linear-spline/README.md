# Linear spline - spline of the first order
- Spline - piecewised defined function used to approximate or interpolate data points.
- That is, if we have a function and there are known nodes/points, then we can find the approximate values of y from the x's that are between the nodes.
- For linear spline we must have at least 2 known data points.
- Order of approximation is the second. This means that for linear functions the interpolation will be maximally accurate. But for functions with a higher degree of the senior polynomial (parabolas, etc.) an error appears.
- To solve this I used Newton's interpolation formula:
- F(x) = F(xi) + (F(xi+1)-F(xi)) / (xi+1 - xi) * (x - xi)
