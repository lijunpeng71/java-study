package com.xuelianyong.interview.thread;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-24 14:07
 **/
public class TemplateMethod {

    public final void print(String message){
        System.out.println("################");
        wrapPrint(message);
        System.out.println("################");
    }

    protected void wrapPrint(String message){}


    public static void main(String[] args) {
        TemplateMethod templateMethod01=new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };
        templateMethod01.print("Hello thread");
    }
}
