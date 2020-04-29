package com.hr.springboot.request;

import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/17 10:35
 * @Description:
 */
@Data
public class User {
    private String username;
    private String password;
    private String salt;
}
