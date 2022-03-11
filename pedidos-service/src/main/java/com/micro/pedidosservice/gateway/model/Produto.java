package com.micro.pedidosservice.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Produto {
    @Id
    private String id;
    private String nome;
    private Tipo tipo;
    private Double preco;
    private String cnpjFornecedor;
    private Double estoque;

}