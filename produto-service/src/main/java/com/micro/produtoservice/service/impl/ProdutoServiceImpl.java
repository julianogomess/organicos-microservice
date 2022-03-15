package com.micro.produtoservice.service.impl;

import com.micro.produtoservice.gateway.model.ItemPedido;
import com.micro.produtoservice.gateway.model.ItemPedidoDTO;
import com.micro.produtoservice.model.Produto;
import com.micro.produtoservice.model.Tipo;
import com.micro.produtoservice.repository.ProdutoRepository;
import com.micro.produtoservice.service.FornecedorService;
import com.micro.produtoservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository pr;

    @Autowired
    FornecedorService fornecedorService;

    @Override
    public List<Produto> findAll() {
            return pr.findAll();
        }

        @Override
        public Produto save(Produto produto, String cnpj) {
            boolean teste = fornecedorService.checkCnpj(cnpj);
            if (!teste) {
                return null;
            }
            produto.setCnpjFornecedor(cnpj);
            return pr.save(produto);
        }

        @Override
        public List<Produto> findByTipo(Tipo tipo) {
            return pr.findByTipo(tipo);
        }

        @Override
        public void deleteById(String id) {
            pr.deleteById(id);
        }

        @Override
        public void deleteByNome(String nome) {
            pr.deleteByNome(nome);
        }

        @Override
        public Produto findByNome(String nome) {
            return pr.findByNome(nome);
        }

        @Override
        public Produto findById(String id) {
            Optional<Produto> p = pr.findById(id);
            if (p == null) {
                return null;
            }
            return p.get();
        }

        @Override
        public List<Produto> pesquisaPorNome(String nome) {
            return pr.pesquisPorNome(nome);
        }

        @Override
        public List<Produto> getHome() {
            return pr.getHome();
        }

        @Override
        public Produto atualizarEstoqueProduto(Produto p, Double valor) {
            p.setEstoque(p.getEstoque()-valor);
            return pr.save(p);
        }
        @Override
        public List<ItemPedido> transformarDTO(List<ItemPedidoDTO> lista) {
            List<ItemPedido> items = new ArrayList<>();

            for (ItemPedidoDTO i:lista){
                Produto p = this.findById(i.getId());
                ItemPedido item = new ItemPedido();
                item.setProduto(p);
                item.setQuantidade(i.getQuantidade());
                items.add(item);
            }
            return items;
        }

    @Override
    public void atualizarEstoque(List<ItemPedido> items) {
        Produto p ;
        for (ItemPedido i: items){
            p = i.getProduto();
            this.atualizarEstoqueProduto(p,i.getQuantidade());
        }
    }

    }