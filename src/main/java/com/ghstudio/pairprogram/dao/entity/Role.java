package com.ghstudio.pairprogram.dao.entity;

import lombok.Data;

import java.util.List;

/**
 * Role 用户角色表定义
 */
@Data
public class Role {
    private int id;
    private String name;
    private int value;
    private List<Route> routeList;
}
