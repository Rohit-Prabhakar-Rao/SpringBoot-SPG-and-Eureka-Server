package com.springtesting.api_gateway;

// recursion coding problems for enhancing recursion concept
public class CodeClass {
    //    1. Print numbers from 1 to N using recursion
    //    input - 5
    //    output - 1 2 3 4 5
    //    public void printf(int n){
    //        if(n == 0) return;
    //
    //        printf(n - 1);       // go down till 1
    //        System.out.print(n);    // print while coming back
    //    }

    //    2. Write a recursive function that prints numbers from N down to 1.
    //    input - 5
    //    output - 5 4 3 2 1
    //    public void printf(int n){
    //        if(n == 0) return;
    //
    //        System.out.print(n);
    //        printf(n - 1);
    //    }

    //    3. Write a recursive function to compute:
    //    input - 5
    //    output - 15
    //    public int printf(int n){
    //        if(n <= 1) return n;
    //        return n + printf(n-1);
    //    }

    //    4. Factorial using recursion
    //    Input - 5
    //    Output - 120
    //    public int printf(int n){
    //        if(n == 1 || n == 0) return 1;
    //        return n * printf(n - 1);
    //    }

    //    5. Reverse a string using recursion
    //    input - "abcd"
    //    output - "dcba"
    //    public String printf(String str){
    //        if(str.isEmpty()) return "";
    //        return str.substring(1) + str.charAt(0);
    //    }

    //    6. Remove all occurrences of a character from a string (using recursion)
    //    input str = "bananas"
    //            ch = 'a'
    //    output - "bnns"
    //    public String printf(String str, char ch){
    //        if(str.isEmpty()) return "";
    //        char first = str.charAt(0);
    //        String rest = printf(str.substring(1), ch);
    //        if(first == ch)
    //            return rest;
    //        else
    //            return first + rest;
    //    }
}
