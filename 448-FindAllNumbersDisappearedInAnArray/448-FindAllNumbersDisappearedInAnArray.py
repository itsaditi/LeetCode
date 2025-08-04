# Last updated: 8/4/2025, 4:51:10 PM
'''
Array of N length -> elements not present.

Example: [4,3,2,7,8,2,3,1]
len = 8, 1 <= i <= 8
Output : [5,6]

Example : [1, 1]
len = 2, 1 <= i <= 2
Output : [2]

Constraint : n > 0

Brute force approach -
1) For all the elements from 1 to len(arr), check if that element
does not exists in the array
2) Which ever element does not exist, put it in another array
[1,2,3,4,5,6,7,8] -> 1 not in arr 
                     2 not in arr
                     .
                     .
                     5 not in arr -> True. 
                     6 not in arr -> True.

Time complexity : O(N)
Space complexity : O(N)

BSR :
Hash table - len(arr) { 1:0, 2:0, 3:0, 4:0, 5:0, 6:0, 7:0, 8:0}
1) Traverse the array and check if the value of the encountered element in the hash table is 0.
    1.A) Get the count of that elements. 
2) Map the count to the respective keys. 
[4,3,2,7,8,2,3,1]
         |
4 -> if 0, arr.count(4) -> map to key 4                         { 1:0, 2:0, 3:0, 4:1, 5:0, 6:0, 7:0, 8:0}
3 -> if key for 3 is 0, arr.count(3) -> map to the key 3        { 1:0, 2:0, 3:2, 4:1, 5:0, 6:0, 7:0, 8:0}
2 ->                                                            { 1:0, 2:2, 3:2, 4:1, 5:0, 6:0, 7:0, 8:0}
7 ->    8 ->                                                    { 1:0, 2:2, 3:2, 4:1, 5:0, 6:0, 7:1, 8:1}
Skip 2 and 3
1 ->                                                            { 1:1, 2:2, 3:2, 4:1, 5:0, 6:0, 7:1, 8:1}

Query the hash table for the keys where value of 0.
Time and space Complexity - O(N)

'''


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hasht = {}
        result = []
        
        # Hash table for keeping record of the
        # existing number in array.
        for y in nums :
            hasht[y] = 1
        
        # Iterate over the numbers from 1 to N and put the elements in the
        # result array, if that number does not exist in the 
        # hash table.
        for x in range(1, len(nums) + 1):
            if x not in hasht:
                result.append(x)
            
        
        return result
        
        
        
        
        # arrlen = len(nums)
        # nums = list(set(nums))
        # nums.sort()
        # print(nums[:10])
        # return [x for x in range(1, arrlen+1) if x not in nums]
    
    
    
    
    
    
    
    
    
    
    