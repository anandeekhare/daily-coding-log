Remove Nth node from end:

Steps:
1. Move fast pointer n steps ahead
2. Move slow and fast together
3. When fast reaches end,
   slow will be before node to delete

Technique: Two pointers
Time: O(n)
Space: O(1)
