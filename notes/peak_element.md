Find Peak Element

Peak = element greater than neighbors

Compare:
nums[mid] vs nums[mid+1]

If nums[mid] > nums[mid+1]:
peak in left half
else:
peak in right half

Time: O(log n)
