package com.water.uubook.blog.controller.wap;

import com.water.uubook.blog.model.UserInfo;
import com.water.uubook.blog.repository.UserInfoRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by zhangmiaojie on 2017/12/27.
 */
@Controller
@RequestMapping(value = "/wap")
public class WapBlogController extends BaseWapController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private Configuration configuration;

    @RequestMapping(value = {"/", "index", "index.html"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/wap/index");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("zhangmiaojie");
        userInfo.setPassword("123");
        userInfoRepository.save(userInfo);
        return mav;
    }

    @RequestMapping(value = {"send"}, method = RequestMethod.GET)
    public String sendHtmlMailUsingFreeMarker(Model model, HttpSession session) throws Exception {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "这是测试的内容。。。");
        model.addAttribute("toUserName", "张三");
        model.addAttribute("fromUserName", "老许");

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("time", new Date());
//        map.put("message", "这是测试的内容。。。");
//        map.put("toUserName", "张三");
//        map.put("fromUserName", "老许");

        Template t = configuration.getTemplate("wap/test.ftl"); // freeMarker template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        System.out.println(content);

        return "wap/test";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() throws ExecutionException {
        ModelAndView mav = new ModelAndView("web/list");

        return mav;
    }
}
