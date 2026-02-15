"""
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 
Constraints:
1 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
"""

class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
        self.prev = None
        self.count = 1

class List:
    def __init__(self):
        self.head = Node(-1,-1)
        self.tail = Node(-1,-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0
    
    def addNode(self,newnode):
        temp = self.head.next
        newnode.next = temp
        newnode.prev = self.head
        temp.prev = newnode
        self.head.next = newnode
        self.size+=1

    def deleteNode(self,delNode):
        prev = delNode.prev
        nextt = delNode.next
        prev.next = nextt
        nextt.prev = prev
        self.size-=1

class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.keyNodeMap = {}
        self.freqListMap = {}
        self.minfreq = 0
        self.cursize = 0
    
    def updateFreqList(self,node):
        del self.keyNodeMap[node.key]
        self.freqListMap[node.count].deleteNode(node)
        if(node.count == self.minfreq and self.freqListMap[node.count].size == 0):
            self.minfreq += 1

        newList = List()

        if node.count+1 in self.freqListMap:
            newList = self.freqListMap[node.count+1]
        
        node.count+=1
        newList.addNode(node)
        self.freqListMap[node.count] = newList
        self.keyNodeMap[node.key] = node


    def get(self, key: int) -> int:
        if key in self.keyNodeMap:
            node = self.keyNodeMap[key]
            self.updateFreqList(node)
            return node.value
        return -1
        

    def put(self, key: int, value: int) -> None:
        if(self.capacity == 0):
            return 
        if key in self.keyNodeMap:
            node = self.keyNodeMap[key]
            node.value = value
            self.updateFreqList(node)
        else:
            if self.cursize == self.capacity:
                listt = self.freqListMap[self.minfreq]
                del self.keyNodeMap[listt.tail.prev.key]
                self.freqListMap[self.minfreq].deleteNode(listt.tail.prev)
                self.cursize-=1
            self.cursize+=1
            self.minfreq = 1
            newlist = List()
            if self.minfreq in self.freqListMap:
                newlist = self.freqListMap[self.minfreq]    
            node = Node(key,value)
            newlist.addNode(node)
            self.keyNodeMap[key] = node
            self.freqListMap[self.minfreq] = newlist
