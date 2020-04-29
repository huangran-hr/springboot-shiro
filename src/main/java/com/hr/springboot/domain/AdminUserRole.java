package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Data
@Table(name = "admin_user_role")
public class AdminUserRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`uid`")
    private Integer uid;

    @Column(name = "rid")
    private Integer rid;
}