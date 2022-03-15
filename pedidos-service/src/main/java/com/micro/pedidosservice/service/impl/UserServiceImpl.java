package com.micro.pedidosservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.pedidosservice.gateway.model.PedidoJson;
import com.micro.pedidosservice.gateway.model.RespJson;
import com.micro.pedidosservice.gateway.model.UserRequest;
import com.micro.pedidosservice.gateway.producer.UserProducer;
import com.micro.pedidosservice.service.UserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserProducer producer;

    @Override
    public boolean existByCpf(String cpf) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ConsumerRecord<String,String> consumerRecord = producer.get(cpf);
        UserRequest userExist = mapper.readValue(consumerRecord.value(), UserRequest.class);
        return userExist.isExists();
    }
}
