# Near-linear sorting algorithms
They are called near-linear sorting algorithms because their average or expected complexity is close to linear - O(n), in contrast to conventional comparison sorts, where the lower bound is O(n log n).

"Near" because they can indeed run in O(n) under certain conditions (e.g. limited range of values, uniform distribution). But they do not guarantee linear speed always.

## BucketSort
Idea:
- Split elements into groups ("buckets") by value ranges, sort within each bucket (e.g. Insertion Sort), then combine all buckets into one array.

When to use:
- Elements are evenly distributed.
- Numbers are in a limited range (e.g. 0–100).
- Suitable for fractions and real numbers (unlike Counting Sort).

Time Complexity: in average O(n + k), worst case - O(n^2) if all elements are in one bucket.

## Counting Sort
Idea:
- Count how many times each number occurs. Then reconstruct the sorted array based on the frequencies.

When to use:
- Integers
- Values ​​in a small range (e.g. 0–1000)
- Stable and not comparative

Time Complexity: O(n + k), k - max. value in array.

## Radix Sort
Idea:
- Sorts numbers digit by digit: first by ones, then by tens, hundreds, etc., using the stable Counting Sort as a subfunction.

When to use:
- Positive integers
- Number of digits (d) is small

Time Complexity: O(d * (n + k)), d is the number of digits, k is the base (usually 10). 
