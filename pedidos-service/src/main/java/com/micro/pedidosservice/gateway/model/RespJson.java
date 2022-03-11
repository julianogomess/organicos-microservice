package com.micro.pedidosservice.gateway.model;


import com.micro.pedidosservice.model.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class RespJson {
    private List<ItemPedido> lista;
}
