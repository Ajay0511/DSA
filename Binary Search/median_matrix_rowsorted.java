class Solution {
    public int upperBound(int[][] mat, int x, int m, int n){
        int cnt = 0;
        for(int i=0;i<m;i++){
            int low = 0;
            int high = n;
            int[] arr = mat[i];
            while(low<high){
                int mid = (low+high)/2;
                if(arr[mid]<=x){
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            cnt += low;
        }
        return cnt;
    }
    public int median(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i =0;i<m;i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high,mat[i][n-1]);
        }
        int req = (m*n)/2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(upperBound(mat,mid,m,n) <= req){
                low = mid+1;
            } else{
                high = mid - 1;
            }
        }
        return low;
        
    }
}