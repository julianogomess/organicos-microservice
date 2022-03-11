package com.micro.produtoservice.gateway.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespJson {
    private List<ItemPedido> lista;
}