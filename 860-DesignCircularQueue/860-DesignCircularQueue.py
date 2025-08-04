# Last updated: 8/4/2025, 4:50:50 PM
class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = []*k
        self.count = 0
        self.capacity = k

    def enQueue(self, value: int) -> bool:
        if len(self.queue) == self.capacity:
            return False
        
        self.queue.append(value)
        self.count += 1
        return True
        

    def deQueue(self) -> bool:
        if len(self.queue) == 0:
            return False
        
        self.queue.pop(0)
        self.count -= 1
        return True
        

    def Front(self) -> int:
        if len(self.queue) == 0:
            return -1
        
        return self.queue[0]
        

    def Rear(self) -> int:
        if len(self.queue) == 0:
            return -1
        
        print(self.queue)
        return self.queue[len(self.queue)-1]

    def isEmpty(self) -> bool:
        return self.count == 0
        

    def isFull(self) -> bool:
        return self.count == self.capacity
        


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()