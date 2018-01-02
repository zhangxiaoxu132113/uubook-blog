package com.water.uubook.blog.controller.pc;

import com.water.uubook.blog.model.ArticleDocument;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangmiaojie on 2017/12/27.
 */
@Controller
@RequestMapping(value = "/pc")
public class PcBlogController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, Model model) {

        ModelAndView mav = new ModelAndView("web/index");
        return  mav;
    }}
