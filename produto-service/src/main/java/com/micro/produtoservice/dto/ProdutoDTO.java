package com.micro.produtoservice.dto;

import com.micro.produtoservice.model.Produto;
import com.micro.produtoservice.model.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {
    @NotBlank(message = "Campo Nome é obrigatório")
    private String nome;
    @NotNull(message = "Campo Tipo é obrigatório")
    private Tipo tipo;
    @PositiveOrZero
    private Double preco;
    @NotNull(message = "Campo estoque é obrigatório")
    private Double estoque;

    public Produto trasnformar(){
        Produto p = new Produto();
        p.setNome(this.getNome());
        p.setTipo(this.getTipo());
        p.setPreco(this.getPreco());
        p.setEstoque(this.getEstoque());
        return p;
    }
}