//package com.water.uubook.blog;
//
//import freemarker.template.TemplateException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
//
//import java.io.IOException;
//
///**
// * Created by zhangmiaojie on 2017/12/28.
// */
//@Configuration
//public class WebViewResolverConfiguration {
//
//    @Bean
//    public ViewResolver getJspViewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//        internalResourceViewResolver.setSuffix(".jsp");
////        internalResourceViewResolver.setViewNames("jsp/*");
//        internalResourceViewResolver.setViewClass(JstlView.class);
//        internalResourceViewResolver.setOrder(10);
//        internalResourceViewResolver.setCache(false);
//        return internalResourceViewResolver;
//    }
//
//    @Bean
//    public FreeMarkerViewResolver getFmViewResolver() {
//        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
//        freeMarkerViewResolver.setCache(true);
//        freeMarkerViewResolver.setPrefix("");
//        freeMarkerViewResolver.setSuffix(".ftl");
//        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
////        freeMarkerViewResolver.
//        freeMarkerViewResolver.setOrder(0);
//        return freeMarkerViewResolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
//        FreeMarkerConfigurationFactory freeMarkerConfigurationFactory = new FreeMarkerConfigurationFactory();
//        freeMarkerConfigurationFactory.setTemplateLoaderPath("classpath:templates");
//        freeMarkerConfigurationFactory.setDefaultEncoding("UTF-8");
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setConfiguration(freeMarkerConfigurationFactory.createConfiguration());
//        return freeMarkerConfigurer;
//    }
//}
