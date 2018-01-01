package com.water.uubook.blog.mq;

import com.water.uubook.blog.utils.CreateHtmlUtils;
import com.water.uubook.blog.utils.MessageQueueHelper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangmiaojie on 2017/12/26.
 */
@Component
public class CreateHtmlThreadMessageListener {
    private ExecutorService threadPool = Executors.newFixedThreadPool(6);

    @JmsListener(destination = MessageQueueHelper.CREATE_HTML_MESSAGE_QUEUE)
    public void receiveQueue(final CreateHtmlMessage message) {
        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                CreateHtmlUtils.createHtml(message.getTemplatePath(), message.getTemplateName(),
                        message.getRequestPath(), message.getModel());
            }
        });

    }
}
