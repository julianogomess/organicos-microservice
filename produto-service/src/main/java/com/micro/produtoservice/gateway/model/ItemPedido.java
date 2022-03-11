package com.micro.produtoservice.gateway.model;

import com.micro.produtoservice.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private Produto produto;
    private Double quantidade;
}