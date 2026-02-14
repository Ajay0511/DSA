/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

import java.util.HashMap;
import java.util.Map;

class Node{
    Integer key;
    Integer val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Integer capacity;
    Node left;
    Node right;
    Map<Integer, Node> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node){
        Node nxt = node.next;
        Node previous = node.prev;
        previous.next = nxt;
        nxt.prev = previous;
    }

    public void insert(Node node){
        Node mru = right.prev;
        mru.next = node;
        node.prev = mru;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if(cache.size() > capacity){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
