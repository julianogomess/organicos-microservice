package com.micro.pedidosservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

@Configuration
public class KafkaConfig {
    @Bean
    public ReplyingKafkaTemplate<String, String, String> replyingTemplate(
            ProducerFactory<String, String> pf,
            ConcurrentMessageListenerContainer<String, String> repliesContainer) {

        return new ReplyingKafkaTemplate<>(pf, repliesContainer);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> repliesContainer(
            ConcurrentKafkaListenerContainerFactory<String, String> containerFactory) {

        ConcurrentMessageListenerContainer<String, String> repliesContainer =
                containerFactory.createContainer("replyListaProduto","replyUser");
        repliesContainer.getContainerProperties().setGroupId("repliesGroup");
        repliesContainer.setAutoStartup(false);
        return repliesContainer;
    }

    @Bean
    public NewTopic requestListaProduto() {
        return TopicBuilder.name("requestListaProduto")
                .partitions(10)
                .replicas(2)
                .build();
    }

    @Bean
    public NewTopic replyListaProduto() {
        return TopicBuilder.name("replyListaProduto")
                .partitions(10)
                .replicas(2)
                .build();
    }
    @Bean
    public NewTopic requestUser() {
        return TopicBuilder.name("requestUser")
                .partitions(10)
                .replicas(2)
                .build();
    }

    @Bean
    public NewTopic replyUser() {
        return TopicBuilder.name("replyUser")
                .partitions(10)
                .replicas(2)
                .build();
    }
}
