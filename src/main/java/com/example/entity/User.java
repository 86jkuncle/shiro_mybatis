package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2019/9/16 10:08
 */
@Getter
@Setter
@Accessors(chain = true)
@Alias("User")
public class User implements Serializable {
    private static final long serialVersionUID = -8821293653046280269L;
    private Integer id;
    private String username;
    private String password;
    private Integer status;
}
