package com.micro.fornecedorservice.gateway.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.fornecedorservice.model.Fornecedor;
import com.micro.fornecedorservice.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class FornecedorListener {

    @Autowired
    private FornecedorService fornecedorService;

    @KafkaListener(id="server", topics = "requestFornecedor",groupId = "micro")
    @SendTo // use default replyTo expression
    public String listen(String in) throws JsonProcessingException {
        Fornecedor f = fornecedorService.findByCnpj(in);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(f);
    }


}
