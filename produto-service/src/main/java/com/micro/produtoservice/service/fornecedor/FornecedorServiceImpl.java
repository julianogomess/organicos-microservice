package com.micro.produtoservice.service.fornecedor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.produtoservice.gateway.producer.FornecedorProducer;
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
    private FornecedorProducer producer;


    public FornecedorDTO execute(String cnpj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ConsumerRecord<String,String> consumerRecord = producer.get(cnpj);
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
