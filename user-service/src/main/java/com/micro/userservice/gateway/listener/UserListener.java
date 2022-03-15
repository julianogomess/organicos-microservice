package com.micro.userservice.gateway.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.userservice.gateway.model.UserRequest;
import com.micro.userservice.model.User;
import com.micro.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class UserListener {

    @Autowired
    UserService userService;

    @KafkaListener(id = "server",topics = "requestUser")
    @SendTo("replyUser")
    public String listen(String cpf) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User u = userService.findByCpf(cpf);
        UserRequest userRequest = new UserRequest();
        if(u!=null){
            userRequest.setExists(true);
        }else {
            userRequest.setExists(false);
        }
        return mapper.writeValueAsString(userRequest);
    }
}
