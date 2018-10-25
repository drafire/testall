package com.drafire.testall.webservice;

public class Bootstrap {
    public static void main(String[] args) {
        SayHelloImpl hello = new SayHelloImplService().getSayHelloImplPort();
        String str = hello.say();
        System.out.println(str);
    }
}
