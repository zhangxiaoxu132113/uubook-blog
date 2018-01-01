package com.water.uubook.blog.controller.wap;

import com.water.uubook.blog.ArticleService;
import com.water.uubook.blog.annotation.GenerateHtml;
import com.water.uubook.blog.model.ArticleDocument;
import com.water.uubook.blog.mq.CreateHtmlMessage;
import com.water.uubook.blog.mq.MessageThreadService;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangmiaojie on 2017/12/27.
 */
@Controller
@RequestMapping(value = "/wap")
public class WapBlogController extends BaseWapController {

    @Resource(name = "articleService")
    private ArticleService articleService;

    @Resource
    private MessageThreadService messageThreadService;

    @Autowired
    private Configuration configuration;

    @GenerateHtml
    @RequestMapping(value = {"/", "index", "index.html"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        List<ArticleDocument> articleDocumentList = articleService.getTopArticleDocument();
        model.addAttribute("articleList", articleDocumentList);

        model.addAttribute("base", getBase(request));
        return "wap/index";
    }

    /**
     * 文章详情页
     *
     * @return
     * @throws Exception
     */
    @GenerateHtml
    @RequestMapping(value = "/article/detail/{articleId}.html", method = RequestMethod.GET)
    public String articleDetail(Model model, HttpServletRequest request, @PathVariable String articleId) throws Exception {
        ArticleDocument articleDocument = articleService.findArticleById(Integer.parseInt(articleId));
        model.addAttribute("article", articleDocument);
        model.addAttribute("base", getBase(request));

        return "wap/articleDetail";
    }


    @RequestMapping(value = "/article/category/{categoryId}", method = RequestMethod.GET)
    public String list() {
        return "wap/category";
    }
}
