package com.hr.springboot.result;

/**
 * @Auther: HR
 * @Date: 2020/4/23 11:02
 * @Description:
 */
public class ResultFactory {

    public static Result buildSuccessResult() {
        return new Result(200,"成功");
    }

    public static Result buildSuccessResult(String message) {
        return new Result(200,message);
    }

    public static Result buildFailResult(String message) {
        return new Result(400,message);
    }
}
