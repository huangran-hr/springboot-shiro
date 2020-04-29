package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "`name`")
    private String name;
}
