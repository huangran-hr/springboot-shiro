package com.hr.springboot.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:42
 * @Description:
 */
/**
    * 角色权限表
    */
@Data
@Table(name = "tb_role_permission")
public class TbRolePermission {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Long permissionId;
}