package com.water.uubook.blog.utils.aop;

import com.water.uubook.blog.mq.CreateHtmlMessage;
import com.water.uubook.blog.mq.MessageThreadService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 切面：实现访问请求，生成静态文件
 * Created by zhangmiaojie on 2018/1/1.
 */
@Aspect
@Component
public class GenerateHtmlAspect {
    protected String templatesPath;

    @Resource
    private MessageThreadService messageThreadService;

    @Pointcut("@annotation(com.water.uubook.blog.annotation.GenerateHtml)")
    public void controllerAspect() {
    }

    /**
     * 目标方法执行完后调用
     */
    @AfterReturning(pointcut = "controllerAspect()", returning = "returnValue")
    public void applause(JoinPoint point, String returnValue) {
        Model model = null;
        String requestPath = null;
        HttpServletRequest request = null;
        for (Object obj : point.getArgs()) {
            if (obj instanceof Model) {
                model = (Model) obj;
            } else if (obj instanceof HttpServletRequest) {
                request = (HttpServletRequest) obj;
            }
        }

        if (request == null) {
            throw new RuntimeException("request对象为空，获取不到请求的路径");
        }
        requestPath = request.getRequestURI();
        messageThreadService.sendCreateHtmlMessage(new CreateHtmlMessage(this.getTemplatesPath(request),
                returnValue, requestPath, model));
    }

    public String getTemplatesPath(HttpServletRequest request) {
        if (templatesPath == null) {
            synchronized (this) {
                if (templatesPath == null) {
//                    templatesPath = "/Users/mrwater/Documents/git_house/uubook-blog/src/main/webapp/templates";
                    templatesPath = "/data/templates/";
                }
            }
        }
        return templatesPath;
    }

    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }
}
