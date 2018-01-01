package com.water.uubook.blog.model;


import java.util.Date;
import java.util.List;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
public class ArticleDocument implements java.io.Serializable{

    private Integer id;
    private Integer viewHits = 0;
    private Integer module;
    private String title;
    private String description;
    private String content;
    private String categoryStr = "";
    private List<String> tags;
    private Date createTime;

    private List<ArticleDocument> relativeArticleDocument;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewHits() {
        return viewHits;
    }

    public void setViewHits(Integer viewHits) {
        this.viewHits = viewHits;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryStr() {
        return categoryStr;
    }

    public void setCategoryStr(String categoryStr) {
        this.categoryStr = categoryStr;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ArticleDocument> getRelativeArticleDocument() {
        return relativeArticleDocument;
    }

    public void setRelativeArticleDocument(List<ArticleDocument> relativeArticleDocument) {
        this.relativeArticleDocument = relativeArticleDocument;
    }
}
