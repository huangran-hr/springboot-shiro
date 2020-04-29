package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
@Data
@Table(name = "admin_permission")
public class AdminPermission {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 权限的名称，推荐使用英文
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 权限功能的具体描述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 权限对应的接口，是实现功能控制的关键
     */
    @Column(name = "url")
    private String url;
}