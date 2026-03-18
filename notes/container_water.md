Container With Most Water

Use two pointers:
left = 0
right = n-1

Area = min(height[left], height[right]) * width

Move pointer with smaller height

Time: O(n)
Space: O(1)
