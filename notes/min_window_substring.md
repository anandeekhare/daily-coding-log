Minimum Window Substring

Goal:
Find smallest window containing all characters of t

Use:
HashMap for frequency

Expand window -> right++
Shrink window -> left++

Condition:
count == length of t

Time: O(n)
