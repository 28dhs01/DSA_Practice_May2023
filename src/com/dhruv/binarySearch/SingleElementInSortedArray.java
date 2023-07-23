package com.dhruv.binarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8} ;
        int ans = helper(nums) ;
        System.out.println(ans);
    }
    static int helper(int[] nums){
        int s = 0 ;
        int e = nums.length-1 ;
        while( s<=e ){
            int m = s+(e-s)/2 ;
            // duplicate found
            if( ( m>0 && nums[m] == nums[m-1] ) || ( m+1<nums.length && nums[m]==nums[m+1] ) ){
                // search on left
                int fst_idx = m ;
                if( m>0 && nums[m] == nums[m-1] ){
                    fst_idx = m-1 ;
                }
                int rem_size = e-fst_idx+1;
                if( rem_size % 2 == 0 ){
                    e = fst_idx-1 ;
                }
                // search on right
                else{
                    s = fst_idx+2 ;
                }
            }
            // got the result
            else{
                return nums[m] ;
            }
        }
        return -1 ;
    }
}
