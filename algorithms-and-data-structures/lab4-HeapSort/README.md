# HeapSort
HeapSort is a sorting algorithm based on a binary heap, usually a max-heap. It consists of two main steps:
- Building a max-heap from the input array.
- Extracting the maximum element (the root of the heap) and moving it to the end of the array, then restoring the heap properties to the rest.

The algorithm works in-place, does not require additional memory, except for recursion in heapify.

- Time Complexity: always O(nlogn)
- Space Complexity: O(1)
- Unstable (relative order of equal elements is not preserved).
## Heapify function
- It creates maxHeap with root in i. We look at the children and if one's value of them is greater than root's value, we swap them and recursively repeat the algorithm for broken branch.
## HeapSort function
- Uses heapify function to turn the array into maxheap. We start creating maxHeap from the last parent (node that has at least one child, index = (n/2-1)).
- Then we swap first element with the last element to move the largest value to the end and restore maxHeap from the start not taking into account the last element.
