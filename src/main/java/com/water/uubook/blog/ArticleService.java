package com.water.uubook.blog;

import com.water.es.entry.ESDocument;
import com.water.es.entry.ITArticle;
import com.water.uubook.blog.model.ArticleDocument;
import com.water.uubook.blog.repository.ArticleDocumentRepository;
import com.water.uubook.model.TbUbTag;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.service.TbUbArticleService;
import com.water.uubook.service.TbUbTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by zhangmiaojie on 2017/12/31.
 */
@Service("articleService")
public class ArticleService {

    @Resource(name = "tbUbArticleService")
    private TbUbArticleService tbUbArticleService;

    @Resource
    private com.water.es.api.Service.IArticleService esArticleService;

    @Resource
    private ArticleDocumentRepository articleDocumentRepository;

    @Resource
    private TbUbTagService tbUbTagService;

    public List<ArticleDocument> getTopArticleDocument() {
        Map<String, String> sortMap = new HashMap<>();
        TbUbArticleDto model = new TbUbArticleDto();
        model.setModule(0);
        sortMap.put("createOn", "desc");
        String[] queryField = new String[]{"id", "title", "viewHits", "tags", "description", "createOn"};

        List<TbUbArticleDto> articleDtoList = tbUbArticleService.findArticleListByCondition(model, queryField, sortMap, 1, 15);
        articleDtoList = tbUbArticleService.getArticleTag(articleDtoList);
        List<ArticleDocument> articleDocumentList = transformArticleDocument(articleDtoList);

        return articleDocumentList;
    }

    private List<ArticleDocument> transformArticleDocument(List<TbUbArticleDto> articleDtoList) {
        List<ArticleDocument> articleDocumentList = new ArrayList<>();
        ArticleDocument articleDocument;
        if (articleDtoList != null) {
            for (TbUbArticleDto articleDto : articleDtoList) {
                articleDocument = new ArticleDocument();
                BeanUtils.copyProperties(articleDto, articleDocument);
                //设置文章的标签
                this.setArticleTags(articleDto, articleDocument);
                articleDocumentList.add(articleDocument);
            }
        }
        return articleDocumentList;
    }


    /**
     * 根据文章id获取文章详情
     *
     * @param articleId
     * @return
     */
    public ArticleDocument findArticleById(Integer articleId) {
        ArticleDocument articleDocument = articleDocumentRepository.findOne(articleId);
        if (articleDocument == null) {
            TbUbArticleDto articleDto = tbUbArticleService.findArticleById(articleId);
            if (articleDto != null) {
                articleDocument = new ArticleDocument();
                BeanUtils.copyProperties(articleDto, articleDocument);
                articleDocument.setCategoryStr(articleDto.getTbUbCategoryDto().getName());
                articleDocument.setCreateTime(new Date(articleDto.getCreateOn()));
                //设置文章的标签
                this.setArticleTags(articleDto, articleDocument);
                //相关文章
                this.setRelativeArticle(articleDto, articleDocument);
                articleDocumentRepository.insert(articleDocument);
            }
        }

        return articleDocument;
    }

    private void setArticleTags(TbUbArticleDto articleDto, ArticleDocument articleDocument) {
        //设置文章的标签
        if (StringUtils.isNotBlank(articleDto.getTags())) {
            List<TbUbTag> tagList = tbUbTagService.findArticleTags(articleDto.getTags());
            if (tagList != null) {
                List<String> tagStrList = new ArrayList<>();
                for (TbUbTag tag : tagList) {
                    tagStrList.add(tag.getName());
                }
                articleDocument.setTags(tagStrList);
            }
        }
    }

    private void setRelativeArticle(TbUbArticleDto articleDto, ArticleDocument articleDocument) {
        ESDocument esDocument = esArticleService.searchArticleByMatch("content", articleDto.getTitle(), 0, 8);
        if (esDocument != null) {
            List<ITArticle> esArticleList = (List<ITArticle>) esDocument.getResult();
            List<ArticleDocument> articleDocumentList = new ArrayList<>();
            for (com.water.es.entry.ITArticle esArticle : esArticleList) {
                ArticleDocument originArticle = new ArticleDocument();
                BeanUtils.copyProperties(esArticle, originArticle);
                articleDocumentList.add(originArticle);
            }
            articleDocument.setRelativeArticleDocument(articleDocumentList);
        }
    }
}
