package com.water.uubook.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhangmiaojie on 2017/12/31.
 */
@Configuration
@ImportResource(value = {"spring-mybatis.xml","spring-dubbo-consumer.xml"})
public class WebConfiguration {
}
