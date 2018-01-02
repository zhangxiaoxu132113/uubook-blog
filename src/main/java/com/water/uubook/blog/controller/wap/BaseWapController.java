package com.water.uubook.blog.controller.wap;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
@Controller
public class BaseWapController {
    @Autowired
    protected Configuration configuration; //freeMarker configuration

    protected String templatesPath;

    protected String base;

    public String getTemplatesPath() {
        if (templatesPath == null) {
            synchronized (this) {
                if (templatesPath == null) {
                    templatesPath = this.getClass().getResource("/WEB-INF/views/templates").getPath();
                }
            }
        }
        return templatesPath;
    }

    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }

    public String getBase(HttpServletRequest request) {
        if (base == null) {
            synchronized (this) {
                if (base == null) {
                    base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
                }
            }
        }
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
