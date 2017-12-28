package com.water.uubook.blog.repository;

import com.water.uubook.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
public interface ArticleRepository  extends MongoRepository<Article, Integer> {
}
