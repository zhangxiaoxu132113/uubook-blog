package com.water.uubook.blog.mq;

import com.water.uubook.blog.utils.MessageQueueHelper;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by ZMJ on 2017/12/26.
 */
@Component("messageThreadService")
public class MessageThreadService {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final Object message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送生成静态html的message实体
     * @param message CreateHtmlMessage
     */
    public void sendCreateHtmlMessage(CreateHtmlMessage message) {
        Destination destination = new ActiveMQQueue(MessageQueueHelper.CREATE_HTML_MESSAGE_QUEUE);
        this.sendMessage(destination, message);
    }
}
