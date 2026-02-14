# reverse stack using list

stack = [1, 2, 3, 4]

reversed_stack = []

while stack:
    reversed_stack.append(stack.pop())

print(reversed_stack)
