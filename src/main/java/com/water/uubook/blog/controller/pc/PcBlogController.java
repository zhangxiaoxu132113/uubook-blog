package com.water.uubook.blog.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhangmiaojie on 2017/12/27.
 */
@Controller
@RequestMapping(value = "/pc")
public class PcBlogController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("web/index");

        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() throws ExecutionException {
        ModelAndView mav = new ModelAndView("web/list");

        return mav;
    }
}
