package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
@Data
@Table(name = "admin_role_permission")
public class AdminRolePermission {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "rid")
    private Integer rid;

    @Column(name = "pid")
    private Integer pid;
}