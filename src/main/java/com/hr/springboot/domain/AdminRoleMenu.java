package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Data
@Table(name = "admin_role_menu")
public class AdminRoleMenu {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "rid")
    private Integer rid;

    @Column(name = "mid")
    private Integer mid;
}