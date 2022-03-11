package com.micro.pedidosservice.gateway.producer;

import com.micro.pedidosservice.gateway.model.PedidoJson;
import com.micro.pedidosservice.model.Pedido;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProdutoProducer {

    @Autowired
    private ReplyingKafkaTemplate<String, String, String> kafkaTemplate;

    public ConsumerRecord<String,String> get(String json) throws Exception{
        ProducerRecord<String, String> record = new ProducerRecord<>("requestListaProduto", json);
        RequestReplyFuture<String, String, String> replyFuture = kafkaTemplate.sendAndReceive(record);
        SendResult<String, String> sendResult = replyFuture.getSendFuture().get(10, TimeUnit.SECONDS);
        ConsumerRecord<String, String> consumerRecord = replyFuture.get(10, TimeUnit.SECONDS);
        return consumerRecord;
    }
}
