/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {

    static class Pair{
        int freq;
        int ele;
        public Pair(int freq, int ele){
            this.freq = freq;
            this.ele = ele;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.freq - y.freq);

        for(int num:nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            Pair p = new Pair(value, key);
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++){
            Pair pe = pq.poll();
            ans[i] = pe.ele;
        }
        return ans;
    }
}
