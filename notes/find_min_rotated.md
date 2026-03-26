Find Minimum in Rotated Sorted Array

Compare mid with right:

if nums[mid] > nums[right]:
    min is in right half
else:
    min is in left half (including mid)

Time: O(log n)
