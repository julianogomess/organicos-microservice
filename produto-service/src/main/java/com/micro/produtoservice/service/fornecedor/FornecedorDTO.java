package com.micro.produtoservice.service.fornecedor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FornecedorDTO {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cnpj;
    private Endereco endereco;

}