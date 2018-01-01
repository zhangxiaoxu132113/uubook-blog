package com.water.uubook.blog.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by mrwater on 2017/12/31.
 */
public class CreateHtmlUtils {

    private final static String STATIS_HTML = "/Users/mrwater/Documents/tumblr";

    private final static Log log = LogFactory.getLog(CreateHtmlUtils.class);

    private final static String TEMPLATE_SUFFIX_NAME = ".html";

    public static void createHtml(String templatePath, String templateName, String requestPath, Object model) {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate(templateName + TEMPLATE_SUFFIX_NAME);
            String filePath = getCreateHtmlPath(requestPath);
            File outPath = new File(filePath);
            Writer writer = new OutputStreamWriter(new FileOutputStream(outPath), "UTF-8");
            template.process(model, writer);
            log.info("生成成功~~，输出路径：" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCreateHtmlPath(String requestPath) {
        String tmpPath = requestPath.substring(0, requestPath.lastIndexOf("/"));
        String filePath = STATIS_HTML + tmpPath;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return STATIS_HTML + (requestPath.contains(".html") ? requestPath : requestPath + ".html");
    }
}
