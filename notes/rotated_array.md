Search in Rotated Sorted Array

Key idea:
One half is always sorted

Check:
nums[left] <= nums[mid] → left sorted
else → right sorted

Then decide which side to search

Time: O(log n)
