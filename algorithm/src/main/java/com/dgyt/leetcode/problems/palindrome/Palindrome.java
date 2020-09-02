package com.dgyt.leetcode.problems.palindrome;

public class Palindrome {


    private static boolean isPalindrome(int x){
        if(x<0) return  false;
        StringBuilder s = new StringBuilder();
        s.append(x);
        String original = s.toString();
        if(original.endsWith("0")){
            return false;
        }
        String result = s.reverse().toString();
        return original.equals(result);
    }
    public static  void main(String[] args){
        Palindrome.isPalindrome(11);
        boolean  result = Palindrome.isPalindrome(10);

        System.out.println(result);


    }


}
