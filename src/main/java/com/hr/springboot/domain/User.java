package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/23 10:44
 * @Description:
 */
@Data
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`salt`")
    private String salt;
}
