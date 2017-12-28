package com.water.uubook.blog.controller.wap;

import com.water.uubook.blog.model.UserInfo;
import com.water.uubook.blog.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhangmiaojie on 2017/12/27.
 */
@Controller
@RequestMapping(value = "/wap")
public class WapBlogController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = {"/", "index", "index.html"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("wap/index");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("zhangmiaojie");
        userInfo.setPassword("123");
        userInfoRepository.save(userInfo);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() throws ExecutionException {
        ModelAndView mav = new ModelAndView("web/list");

        return mav;
    }
}
