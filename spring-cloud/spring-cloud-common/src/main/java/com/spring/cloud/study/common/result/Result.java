package com.spring.cloud.study.common.result;

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
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    /**
     * 成功
     */
    private static final int SUCCESS = 0;

    /**
     * 失败
     */
    private static final int FAILTURE = 999999;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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
