class Solution {

    public void update( int d[],int l,int r){
        d[l]-=1;
        d[r+1]+=1;
    }
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int d[] = new int[n+1];
        d[0] = nums[0];
        d[n] = 0;
        for(int i=1; i<n; i++){
            d[i] = nums[i]-nums[i-1];
        }
        int len = queries.length;
        for(int i=0; i<len; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            update(d,l,r);
        }
        for(int i=0; i<n; i++){
            if(i==0){
                nums[i] = d[i];
                if(d[i]>0){
                    return false;
                }
            }else{
                nums[i] = d[i]+nums[i-1];
                if(nums[i]>0)
                   return false;
            }
        }
        return true;
    }
}