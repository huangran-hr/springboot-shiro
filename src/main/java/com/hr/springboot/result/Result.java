package com.hr.springboot.result;

/**
 * @Auther: HR
 * @Date: 2020/4/17 10:14
 * @Description:
 */
public class Result {
    //响应码
    private int code;
    private String message;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
