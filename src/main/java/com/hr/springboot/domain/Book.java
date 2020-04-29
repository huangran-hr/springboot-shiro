package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
@Data
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "cover")
    private String cover;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "`date`")
    private String date;

    @Column(name = "press")
    private String press;

    @Column(name = "`abs`")
    private String abs;

    @Column(name = "cid")
    private Integer cid;

    //不是表中字段的属性必须加 @Transient 注解
    @Transient
    private String cname;
}
