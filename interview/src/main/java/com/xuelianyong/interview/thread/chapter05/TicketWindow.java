package com.xuelianyong.interview.thread.chapter05;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-24 15:04
 **/
public class TicketWindow extends Thread {
    private final String name;

    private static final int MAX_TICKET = 50;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index < MAX_TICKET) {
            System.out.println("柜台:" + name + "当前号码是:" + index++);
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1=new TicketWindow("一号柜台");
        ticketWindow1.start();
        TicketWindow ticketWindow2=new TicketWindow("二号柜台");
        ticketWindow2.start();
        TicketWindow ticketWindow3=new TicketWindow("三号柜台");
        ticketWindow3.start();
        TicketWindow ticketWindow4=new TicketWindow("四号柜台");
        ticketWindow4.start();
    }
}
