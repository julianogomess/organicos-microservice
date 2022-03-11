package com.micro.pedidosservice.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.micro.pedidosservice.dto.ItemPedidoDTO;
import com.micro.pedidosservice.gateway.model.Produto;
import com.micro.pedidosservice.model.ItemPedido;

import java.util.List;

public interface ProdutoService {
    List<ItemPedido> getList(List<ItemPedidoDTO> lista) throws JsonProcessingException, Exception;
}
