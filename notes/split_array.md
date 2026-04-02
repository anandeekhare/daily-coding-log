Split Array Largest Sum

Goal:
Minimize the largest subarray sum

Search space:
max(nums) → sum(nums)

Check:
How many subarrays needed for given max sum

If subarrays <= k → valid → try smaller
Else → increase

Pattern: Binary Search on Answer
