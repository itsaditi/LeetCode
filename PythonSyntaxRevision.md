# Python Syntax Revision

### Array (Stack)
```python
arr = []
arr = [1, 2, 3]

## Length of Array
len(arr)

## Contains in array
2 in arr ## True
6 in arr ## False

## Iterate over array
for elem in arr:
  print(elem)

## Iterate over array using index
for index in range(0, len(arr)):
  print(arr[index])
```
## Array as Stack

```python
stack = []

# Push to stack
stack.append(3)
stack.append(5)
stack.append(7)

# Pop out of stack
stack.pop() # Returns 7
stack.pop() # Returns 5
stack.pop() # Retuns 3
```

### HashMap
```python
hashMap = {}

## Add to hash map
hashMap[key] = value
hashMap['1'] = 'a'
hashMap['2'] = 'b'

print(hashMap) # {'1': 'a', '2': 'b'}

# In hashMap
'1' in hashMap # True
'4' in hashMap # False
```
