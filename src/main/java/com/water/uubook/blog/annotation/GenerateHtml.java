package com.water.uubook.blog.annotation;

import java.lang.annotation.*;

/**
 * Created by mrwater on 2018/1/1.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenerateHtml {
    String requestPath() default "";

}
