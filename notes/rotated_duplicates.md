Search in Rotated Sorted Array II

Problem:
Duplicates break sorted half detection

Solution:
If nums[left] == nums[mid] == nums[right]:
shrink both sides

Then apply normal rotated binary search

Time: O(n) worst case
