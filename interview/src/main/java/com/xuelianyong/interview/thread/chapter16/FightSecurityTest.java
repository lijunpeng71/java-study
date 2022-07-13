package com.xuelianyong.interview.thread.chapter16;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-04 13:09
 **/
public class FightSecurityTest {

    static class Passengers extends Thread {

        private final FlightSecurity flightSecurity;

        private final String boardingPass;

        private final String idCard;

        public Passengers(FlightSecurity flightSecurity, String boardingPass, String idCard) {
            this.flightSecurity = flightSecurity;
            this.boardingPass = boardingPass;
            this.idCard = idCard;
        }

        @Override
        public void run() {
            while (true) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }

    public static void main(String[] args) {
        final FlightSecurity flightSecurity=new FlightSecurity();
        new Passengers(flightSecurity,"A123456","AF123456").start();
        new Passengers(flightSecurity,"B23456","BF123456").start();
        new Passengers(flightSecurity,"C123456","CF123456").start();
    }
}
