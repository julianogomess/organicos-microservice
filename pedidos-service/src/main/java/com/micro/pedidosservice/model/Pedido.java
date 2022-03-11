package com.micro.pedidosservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Pedidos")
@Getter
@Setter
@NoArgsConstructor
public class Pedido {
    @Id
    private String id;
    private String cpfCliente;
    private List<ItemPedido> lista;
    private Date data;
    private boolean finalizado;
    private Double valor;
    private StatusPedido status;
}
