Top K Frequent Elements

Steps:
1. Count frequency using hashmap
2. Use min heap of size k
3. Store (element, frequency)

Remove smallest frequency when size > k

Time: O(n log k)
