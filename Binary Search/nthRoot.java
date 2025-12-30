class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 0;
        int high = m/n + 1;
        
        while(low<=high){
            int mid = (low+high)/2;
            int val = (int) Math.pow(mid, n);
            if(val == m){
                return mid;
            } else if(val>m){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return -1;
    }
}