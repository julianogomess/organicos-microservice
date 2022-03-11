package com.micro.pedidosservice.errorHandlers;

public class ProdutoIdException extends Exception{
    private final String message = "ID do produto errado! Produto não encontrado!";

    public ProdutoIdException (){
        super();
        String message = this.message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
