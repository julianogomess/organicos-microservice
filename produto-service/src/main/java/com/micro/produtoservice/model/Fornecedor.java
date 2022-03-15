package com.micro.produtoservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;


@Getter
@Setter
@NoArgsConstructor
@Document(collection =  "Fornecedores")
public class Fornecedor {
    @Id
    private String id;
    private String nome;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String telefone;
    @Indexed(unique = true)
    private String cnpj;
    @Valid
    private Endereco endereco;
}
