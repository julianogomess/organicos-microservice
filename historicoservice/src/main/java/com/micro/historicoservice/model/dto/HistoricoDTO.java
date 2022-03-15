package com.micro.historicoservice.model.dto;

import com.micro.historicoservice.model.Historico;
import com.micro.historicoservice.model.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HistoricoDTO {
    @NotBlank(message = "O email do usuário que realizou a pesquisa é necessário")
    private String email;
    @NotBlank(message = "Qual foi o item ou tipo de produto pesquisado")
    private String pesquisa;
    @NotNull(message = "É necessário registrar se o usuário finalizou a compra ou não")
    private boolean realizado;

    public Historico transformar(Tipo tipo, String nome){
        Historico h = new Historico();
        h.setEmail(this.getEmail());
        h.setPesquisa(nome);
        h.setData(new Date());
        h.setTipo(tipo);
        h.setRealizado(this.realizado);
        h.setEnviado(false);
        return h;
    }
}
