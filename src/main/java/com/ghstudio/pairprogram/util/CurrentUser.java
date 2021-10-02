package com.ghstudio.pairprogram.util;


import java.lang.annotation.*;

/**
 * CurrentUser 注解定义
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
