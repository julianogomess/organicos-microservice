package com.micro.produtoservice.service.fornecedor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private ReplyingKafkaTemplate<String, String, String> kafkaTemplate;


    public FornecedorDTO execute(String cnpj) throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
        ObjectMapper mapper = new ObjectMapper();
        ProducerRecord<String, String> record = new ProducerRecord<>("kRequests", cnpj);
        RequestReplyFuture<String, String, String> replyFuture = kafkaTemplate.sendAndReceive(record);
        SendResult<String, String> sendResult = replyFuture.getSendFuture().get(10, TimeUnit.SECONDS);
        ConsumerRecord<String, String> consumerRecord = replyFuture.get(10, TimeUnit.SECONDS);
        FornecedorDTO listJsonRetorn = mapper.readValue(consumerRecord.value(), FornecedorDTO.class);
        return listJsonRetorn;
    }

    @Override
    public boolean checkCnpj(String cnpj) throws Exception {
        FornecedorDTO dto = this.execute(cnpj);
        if (dto==null){
            return false;
        }
        return true;
    }
}
