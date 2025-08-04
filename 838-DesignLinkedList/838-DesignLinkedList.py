# Last updated: 8/4/2025, 4:50:52 PM
'''
Singly Linked List:
'''
'''
class ListNode :
    def __init__(self, x):
        self.val = x
        self.next = None

class MyLinkedList:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 0
        self.head = ListNode(0)

    # O(n)
    def get(self, index: int) -> int:
        # Return -1 is invalid index
        print(self.size)
        if index < 0 or index >= self.size :
            return -1
        
        curr = self.head
        
        indexcounter = 0
        
        curr = curr.next
        while curr is not None :
            if index == indexcounter :
                return curr.val
            
            curr = curr.next
            indexcounter += 1
            
    
        
    # O(1)
    def addAtHead(self, val: int) -> None:
        new_node = ListNode(val)
        curr = self.head
        
        new_node.next = curr.next
        curr.next = new_node
        self.size += 1
        
    
    # O(n)
    def addAtTail(self, val: int) -> None:
        new_node = ListNode(val)
        curr = self.head
        
        while curr != None :
            if curr.next == None:
                curr.next = new_node
                self.size += 1
                return True
            curr = curr.next
            
    #O(n)
    def addAtIndex(self, index: int, val: int) -> None:
        
        if index < 0 :
            return -1
        
        indexcounter = 0
        new_node = ListNode(val)
        curr = self.head
        # curr = curr.next
        while curr != None:
            if  indexcounter == index:
                new_node.next = curr.next
                curr.next = new_node
                self.size += 1
                print(self.size)

                return True
            curr = curr.next
            indexcounter += 1
        
                
    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size :
            return -1
        
        indexcounter = 0
        curr = self.head
        
        while curr is not None:
            if indexcounter == index:
                curr.next = curr.next.next
                self.size -= 1
                return True
            
            curr = curr.next
            indexcounter += 1
        

'''

class ListNode :
    def __init__(self, x):
        self.val = x
        self.next = None
        self.prev = None

class MyLinkedList:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 0
        self.head, self.tail = ListNode(0), ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head

    # O(n)
    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        
        indexcounter = 0
        curr = self.head
        print(curr.next.val)
        while curr is not None and curr.next is not None:
            if indexcounter == index:
                return curr.next.val
            
            curr= curr.next
            indexcounter += 1
            
    
        
    # O(1)
    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)
        # print(self.size)

        
    
#     # O(n)
    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)
        # print(self.size)

            
    #O(n)
    def addAtIndex(self, index: int, val: int) -> None:
        
        if index < 0:
            return -1
        
        newnode = ListNode(val)
        
        indexcounter = 0
        curr = self.head
        self.size += 1    

        while curr is not None :
            if indexcounter == index :
                pred, succ = curr, curr.next
                pred.next = newnode
                newnode.next = succ
                newnode.prev = pred
                succ.prev = newnode
                print(self.head, self.size)

                return True
            curr = curr.next
            indexcounter += 1
        
    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size :
            return -1
        
        indexcounter = 0
        curr = self.head
        
        while curr is not None and curr.next is not None:
            if indexcounter - 1 == index:
                pred, succ = curr.prev, curr.next
                pred.next = succ
                succ.prev = pred
                self.size -= 1
                return True
            
            curr = curr.next
            indexcounter += 1
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)