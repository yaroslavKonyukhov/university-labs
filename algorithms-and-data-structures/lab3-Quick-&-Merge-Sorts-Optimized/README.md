# Optimized versions of QuickSort and MergeSort
- both algorithms use "Divide and Conquer" approach to sort an array.
## QuickSort
- At each recursive level we first find pivot(ussualy it's taken at the end, but it can be taken at the middle or start; also can be choosen randomly), then going through the array we move elements that less than pivot's value to the left from it and elements that great than pivot's value or equal to the right from it. Then we call quicksort function recursively for two new ranges of elements: (start, mid-1) and (mid+1, end). So that way we recursively sort an array.
- Time complixity: best, average cases - O(nlogn), worst case - O(n^2). Worst case is possible if array, for example, is already sorted or pivot is poorly selected.
- Space complexity: stack memory: best, average - O(logn), worst - O(n); additional memory: O(1).
- ### Optimized version:
- We can use two pivots - dualpivot in order to decrease amount of recursion's levels. So sorting becomes faster because we form 3 ranges of elements at each recursion level instead of 2. In my implementation I choose dualpivot randomly due to the task given by teacher.
## MergeSort
- At each recursive level we split array into two parts and going back we connect the elements of the two parts by sorting them. So that way we recursively sort an array.
- Time complixity: always - O(nlogn).
- Space complexity: stack memory: - O(logn); additional memory: O(n), because we need additional array for merging.
- ### Optimized version:
- When amount of elements are less or equal to, for example, 10 we can use insertionSort because it works better with arrays that contain few elements. So that way we decrease amount of recursion's levels and sorting becomes faster.
