package com.micro.pedidosservice.model;

import com.micro.pedidosservice.gateway.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private Produto produto;
    private Double quantidade;
}