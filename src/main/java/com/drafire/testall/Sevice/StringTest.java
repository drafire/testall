package com.drafire.testall.Sevice;

public class StringTest {
    public static void main(String[] args) {
        testBuffer();
        testBuilder();
        //StringBuilder builder=new StringBuilder();
    }

    private static String testBuffer(){
        StringBuffer buffer=new StringBuffer();
        buffer.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        buffer.append("b");
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    private static String testBuilder(){
        StringBuilder builder=new StringBuilder();
        builder.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        builder.append("b");
        System.out.println(builder.toString());
        return builder.toString();
    }
}
