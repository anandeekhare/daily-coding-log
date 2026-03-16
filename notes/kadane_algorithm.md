Maximum Subarray (Kadane's Algorithm)

Idea:
Track running sum of subarray.

If current sum becomes negative,
start new subarray.

currentSum = max(nums[i], currentSum + nums[i])
maxSum = max(maxSum, currentSum)

Time: O(n)
Space: O(1)
