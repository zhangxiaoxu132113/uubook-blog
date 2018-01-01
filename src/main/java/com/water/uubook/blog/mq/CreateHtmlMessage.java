package com.water.uubook.blog.mq;

/**
 * Created by zhangmiaojie on 2018/1/1.
 */
public class CreateHtmlMessage implements java.io.Serializable{
    private String templatePath;
    private String templateName;
    private String requestPath;
    private Object model;

    public CreateHtmlMessage(String templatePath, String templateName, String requestPath, Object model) {
        this.templatePath = templatePath;
        this.templateName = templateName;
        this.requestPath = requestPath;
        this.model = model;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }
}
