package com.spring.cloud.study.common.result;

import java.io.Serializable;

/**
 * <b><code>Result</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 13:43.
 *
 * @author xxx
 * @since java-study
 */
public class Result<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功
     */
    private static final int SUCCESS = 0;

    /**
     * 失败
     */
    private static final int FAILTURE = 999999;

    public Result() {
    }


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isOk() {
        if (this.code == SUCCESS) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> Result success(T data) {
        return new Result(SUCCESS, "success", data);
    }

    public static <T> Result fail(int code, String msg) {
        return new Result(code, msg, null);
    }

    public static <T> Result fail(String msg) {
        return new Result(FAILTURE, msg, null);
    }
}
