package com.water.uubook.blog.repository;

import com.water.uubook.blog.model.ArticleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
public interface ArticleDocumentRepository extends MongoRepository<ArticleDocument, Integer> {
}
