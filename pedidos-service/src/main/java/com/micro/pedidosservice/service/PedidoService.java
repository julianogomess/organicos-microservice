package com.micro.pedidosservice.service;

import com.micro.pedidosservice.dto.ItemPedidoDTO;
import com.micro.pedidosservice.model.ItemPedido;
import com.micro.pedidosservice.model.Pedido;
import com.micro.pedidosservice.model.StatusPedido;

import java.util.List;

public interface PedidoService {
    boolean delete(Pedido pedido);
    List<Pedido> findByUser(String cpf);
    Pedido findById(String id);
    List<Pedido> findAll();
    List<Pedido> findNaoFinalizado();
    Pedido save(List<ItemPedido> items, String idUser);
    Pedido updateStatus(Pedido pedido, StatusPedido status);
    Pedido updatePedido(Pedido pedido);
    List<ItemPedido> transformarDTO(List<ItemPedidoDTO> lista) throws Exception;
    //void atualizarEstoque(List<ItemPedido> items);
}