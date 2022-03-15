package com.micro.produtoservice.gateway.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.produtoservice.gateway.model.ItemPedido;
import com.micro.produtoservice.gateway.model.PedidoJson;
import com.micro.produtoservice.gateway.model.RespJson;
import com.micro.produtoservice.model.Produto;
import com.micro.produtoservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoListener {

    @Autowired
    private ProdutoService produtoService;

    @KafkaListener(id = "server",topics = "requestListaProduto")
    @SendTo("replyListaProduto")
    public String listen(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PedidoJson pedidoJson = mapper.readValue(json,PedidoJson.class);
        List<ItemPedido> lista = produtoService.transformarDTO(pedidoJson.getLista());
        try {
            return mapper.writeValueAsString(RespJson.builder().lista(lista).build());
        }finally {
            produtoService.atualizarEstoque(lista);
        }

    }
}
