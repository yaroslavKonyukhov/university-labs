For the purpose of optimizing algorithms we use such approaches as greedy and divide conquer.

## Greedy
- Greedy algorithms: problem -> sub problem + local optimum -> solve problem + optimization.
- The gist: at each step of solving problem we choose the locally best option with the hope that it leads to the global optimum.

## Divide and Conquer
- Divide and Conquer: problem -> sub problem -> base case -> answer sub problem -> answer problem.
- The gist: split the problem into several smaller ones, solve each one recursively and then combine the solutions.

## Dynamic Programming: DC + tabulation(iterative)/memoization(recursive)
- Sometimes optimizing with just greedy or DC can lead not to best performance. So we need to store intermediate/previous results to decrease the amount of computations(remove duplicate computations). For that we use DP.

## Task1 
- It's connected with the topic of sliding window. We need to find minimum sum of k adjacent elements in the array. We take first k elements, sum them and take as the first minimum sum. Then iteratively update sum and if it's less than previous minimum sum, we update minimum sum.

## Task 2
- Solved with DP: DC + memoization. We need to form the value with minimum amount of coins. The array of coin denominations by condition is already sorted. Solved it recursively, saving computed amounts of coins for specific value to get it from memory in the future to avoid duplicate computations.

## Task 3
- The same task as task 2 but solved with greedy. The array of coin denominations by condition is not sorted. So we sort it in ascending order and go from the right to the left taking "local optimum"/the largest denomination of coins to form the value with the minimum amount of coins.

## Task 4
- Solved with DP: DC + memoization. We need to answer on the question "Can we get zero by substructing 3 or 5 in any order from the value?". So I save boolean values for the specific values to use them in the future in order to avoid duplicate computations.

## Task 5
- Solved with Greedy. We have two arrays: items(stores amount of every item) and costs(stores cost of every item). We have weight. 1 item weighs 1 weight unit. We need to get items as much as we can and the sum of costs must be the maximum possible. So I sorted costs array in ascending order considering items array. Then going from the right to the left first I take items that costs the most. So as the result we have the maximum possible sum of costs.
