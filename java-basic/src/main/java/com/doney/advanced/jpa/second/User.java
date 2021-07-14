package com.doney.advanced.jpa.second;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name="sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

}