package com.junit;

public class Calculator {
    public int add(int x,int y){
        return x + y;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(1,2));
    }
}
