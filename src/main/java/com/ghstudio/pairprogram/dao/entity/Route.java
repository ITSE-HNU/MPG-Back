package com.ghstudio.pairprogram.dao.entity;

import lombok.Data;

/**
 * Route 路由表定义
 */
@Data
public class Route {
    private int id;
    private String path;
    private String method;
}
