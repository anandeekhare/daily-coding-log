Detect & Remove Cycle in Linked List

Algorithm: Floyd's Cycle Detection

Steps:
1. Use slow and fast pointers
2. If they meet -> cycle exists
3. Move slow to head
4. Move both one step
5. Node before cycle start breaks the loop

Time: O(n)
Space: O(1)
