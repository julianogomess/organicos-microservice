package com.micro.pedidosservice.gateway.model;

import com.micro.pedidosservice.dto.ItemPedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoJson {
    private List<ItemPedidoDTO> lista;
}
