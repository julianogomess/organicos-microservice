package com.micro.historicoservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection =  "Historico")
public class Historico {
    @Id
    private String id;
    private String email;
    private String pesquisa;
    private Tipo tipo;
    private Date data;
    private boolean realizado;
    private boolean enviado;
}
