package com.dgyt.code;

public class ReverseInteger {


    public int reverse(int x) {
        long ans;
        long xl = x;
        long abs = Math.abs(xl);
        char[] charArray = new String(abs+"").toCharArray();
        for(int i=0;i<(charArray.length)/2;i++){
            char left = charArray[i];
            char right = charArray[charArray.length-1-i];
            if(left != right){
                char temp = left;
                charArray[i] = right;
                charArray[charArray.length-1-i] = temp;
            }
        }
        ans = Long.valueOf(new String(charArray));
        if(ans >Integer.MAX_VALUE){
            return 0;
        }
        if(x<0) return 0-Integer.valueOf(new String(charArray));
        return Integer.valueOf(new String(charArray));
    }
    public int[] pickTwo(int[] num){
        if(num.length ==2) return num;
        int xor = 0;
        for(int i=0;i<num.length;i++){
            xor^=num[i];
        }




        return null;



    }



    //https://www.jianshu.com/p/0f7c7a48ce18
    public static  void main(String[] args){
       int[] largest = new int[Integer.MAX_VALUE-3];
    }


}
