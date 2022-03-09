package com.micro.produtoservice.service.fornecedor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

}