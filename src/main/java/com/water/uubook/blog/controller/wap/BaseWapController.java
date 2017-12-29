package com.water.uubook.blog.controller.wap;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
@Controller
public class BaseWapController {
    @Autowired
    protected Configuration configuration; //freeMarker configuration

}
