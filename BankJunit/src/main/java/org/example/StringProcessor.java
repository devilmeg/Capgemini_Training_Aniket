package org.example;

public class StringProcessor {

    public String concatenate(String a,String b){
        if(a==null || b==null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        return a+b;
    }

    public boolean isPalindrome(String s){
        if(s==null){
            return false;
        }
       String reversed=new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
