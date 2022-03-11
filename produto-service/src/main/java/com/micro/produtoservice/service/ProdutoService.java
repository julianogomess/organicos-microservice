package com.micro.produtoservice.service;

import com.micro.produtoservice.gateway.model.ItemPedido;
import com.micro.produtoservice.gateway.model.ItemPedidoDTO;
import com.micro.produtoservice.model.Produto;
import com.micro.produtoservice.model.Tipo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ProdutoService {
    List<Produto> findAll();
    Produto save(Produto produto,String cnpj) throws Exception;
    List<Produto> findByTipo(Tipo tipo);
    void deleteById(String id);
    void deleteByNome(String nome);
    Produto findByNome(String nome);
    Produto findById(String id);
    List<Produto> pesquisaPorNome(String nome);
    List<Produto> getHome();
    Produto atualizarEstoque(Produto p, Double valor);
    List<ItemPedido> transformarDTO(List<ItemPedidoDTO> lista);
}