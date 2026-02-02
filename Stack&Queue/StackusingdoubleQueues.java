/*
Problem statement
Implement a Stack Data Structure specifically to store integer data using two Queues.

There should be two data members, both being Queues to store the data internally. You may use the inbuilt Queue.

Implement the following public functions :

1. Constructor:
It initializes the data members(queues) as required.

2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.

3. pop() :
It pops the element from the top of the stack and, in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.

4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.

5. size() :
It returns the size of the stack at any given instance of time.

6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.
Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Pushes an integer data to the stack. (push function)

Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack and returns it to the caller. (pop function)

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the top of the stack but doesn't remove it, unlike the pop function. (top function)

Query-4(Denoted by an integer 4): Returns the current size of the stack. (size function)

Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the stack is empty or not. (isEmpty function)
Example
Operations: 
1 5
1 10
2
3
4

Enqueue operation 1 5: We insert 5 at the back of the queue.
  Queue: [5]

Enqueue operation 1 10: We insert 10 at the back of the queue.
  Queue: [5, 10]

Dequeue operation 2: We remove the element from the front of the queue, which is 5, and print it.
  Output: 5
  Queue: [10]

Peek operation 3: We return the element present at the front of the queue, which is 10, without removing it.
  Output: 10
  Queue: [10]

IsEmpty operation 4: We check if the queue is empty.
  Output: False
  Queue: [10]
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
1 13
1 47
4
5
2
3
Sample Output 1:
2
false
47
13
Explanation of the Sample Input 1:
Here we have six queries in total.

Query 1: Integer 1 represents the push function. Hence we push element ‘13’ onto the stack.

Query 2: Integer 1 represents the push function. Hence we push element ‘47’ onto the stack.

Query 3: Integer 4 represents the size function. Hence we print the size of the stack that is 2.

Query 4: Integer 5 represents the isEmpty function. Hence here, we print false because the stack is not empty.

Query 5: Integer 2 represents the pop function. The stack contains element ‘47’ at the top. We remove/pop ‘47’ from the stack and print ‘47’ on the new line.

Query 6: Integer 3 represents the top function. Because we have element ‘13’ at the top of the stack, we print ‘13’ on the new line.
Constraints:
1 <= Q <= 1000
1 <= query type <= 5
-10^9 <= data <= 10^9 and data != -1

Where 'Q' is the total number of queries being performed on the stack and data represents the integer pushed into the stack. 

Time Limit: 1 second
*/
import java.util.*;
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        this.q1 =  new LinkedList<>();
        this.q2 =  new LinkedList<>();
    }
    
    public void push(int x) {
        //Using q2 to maintain order, main data to be stored in q1
        q2.add(x);

        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q2;
        q1 = q2;
        q2 = temp;

    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.remove();
    }
    
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();        
    }
    
    public boolean empty() {
        return q1.size() == 0;
    }
}

