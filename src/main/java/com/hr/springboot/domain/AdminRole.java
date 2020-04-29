package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Data
@Table(name = "admin_role")
public class AdminRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "name_zh")
    private String nameZh;
}