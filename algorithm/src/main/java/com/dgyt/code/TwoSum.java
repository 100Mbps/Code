package com.dgyt.code;

public class TwoSum {



    public static int[] twoSum(int[] nums, int target) {
        if(nums.length ==1) return  new int[]{0};
        if(nums.length==2) return new int[]{0,1};
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    public static  void main(String[] args){
        twoSum(new int[]{2,4},6);
      // System.out.println(twoSum(new int[]{3,3},6)[0]);
       //System.out.println(twoSum(new int[]{3,3},6)[1]);
    }
}
