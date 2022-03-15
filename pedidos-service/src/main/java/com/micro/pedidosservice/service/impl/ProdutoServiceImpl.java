package com.micro.pedidosservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.pedidosservice.dto.ItemPedidoDTO;
import com.micro.pedidosservice.gateway.model.PedidoJson;
import com.micro.pedidosservice.gateway.model.Produto;
import com.micro.pedidosservice.gateway.model.RespJson;
import com.micro.pedidosservice.gateway.producer.ProdutoProducer;
import com.micro.pedidosservice.model.ItemPedido;
import com.micro.pedidosservice.service.ProdutoService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoProducer producer;


    @Override
    public List<ItemPedido> getList(List<ItemPedidoDTO> lista) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PedidoJson p = new PedidoJson();
        p.setLista(lista);
        ConsumerRecord<String,String> consumerRecord = producer.get(mapper.writeValueAsString(p));
        RespJson listJsonRetorn = mapper.readValue(consumerRecord.value(), RespJson.class);
        return listJsonRetorn.getLista();
    }
}
