package com.xuelianyong.interview.thread.chapter16;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-04 13:10
 **/
public class FlightSecurity {

    private int count = 0;

    /**
     * 登机牌
     */
    private String boardingPass = null;

    /**
     * 身份证
     */
    private String idCard = null;

    public void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
    }

    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("=========Exception=========" + toString());
        }
    }

    @Override
    public String toString() {
        return "FlightSecurity{" + "count=" + count + ", boardingPass='" + boardingPass + '\'' + ", idCard='" + idCard + '\'' + '}';
    }
}
