package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:35
 * @Description:
 */
@Data
@Table(name = "admin_menu")
public class AdminMenu {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 与 Vue 路由中的 path 对应，即地址路径
     */
    @Column(name = "`path`")
    private String path;

    /**
     * 与 Vue 路由中的 name 属性对应
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 中文名称，用于渲染导航栏（菜单）界面
     */
    @Column(name = "name_zh")
    private String nameZh;

    /**
     * element 图标类名，用于渲染菜单名称前的小图标
     */
    @Column(name = "icon_cls")
    private String iconCls;

    /**
     * 组件名，用于解析路由对应的组件
     */
    @Column(name = "component")
    private String component;

    /**
     * 父节点 id，用于存储导航栏层级关系
     */
    @Column(name = "parent_id")
    private Integer parentId;

    @Transient
    private List<AdminMenu> children;
}
