package com.micro.pedidosservice.service.impl;

import com.micro.pedidosservice.dto.ItemPedidoDTO;
import com.micro.pedidosservice.gateway.model.Produto;
import com.micro.pedidosservice.model.ItemPedido;
import com.micro.pedidosservice.model.Pedido;
import com.micro.pedidosservice.model.StatusPedido;
import com.micro.pedidosservice.repository.PedidoRepository;
import com.micro.pedidosservice.service.PedidoService;
import com.micro.pedidosservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    PedidoRepository repository;


    @Autowired
    ProdutoService produtoService;

    @Override
    public boolean delete(Pedido pedido) {
        if(repository.findById(pedido.getId())==null){
            return false;
        }
        repository.delete(pedido);
        return true;
    }

    @Override
    public List<Pedido> findByUser(String cpf) {
        return repository.findByCpfCliente(cpf);
    }

    @Override
    public Pedido findById(String id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(!pedido.isPresent()){
            return null;
        }
        return pedido.get();
    }

    @Override
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Pedido> findNaoFinalizado() {
        return repository.getPedidosByFinalizado(false);
    }

    @Override
    public Pedido save(List<ItemPedido> items, String cpf) {
        Pedido pedido = new Pedido();
        pedido.setCpfCliente(cpf);
        pedido.setLista(items);
        pedido.setData(new Date());
        pedido.setFinalizado(false);
        pedido.setValor(calcValor(items));
        pedido.setStatus(StatusPedido.Realizado);
        pedido = repository.save(pedido);
        return pedido;
    }


    @Override
    public Pedido updateStatus(Pedido pedido, StatusPedido status){
        pedido.setStatus(status);
        if (status.equals(StatusPedido.Entregue)){
            pedido.setFinalizado(true);
        }
        return repository.save(pedido);
    }


    @Override
    public Pedido updatePedido(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public List<ItemPedido> transformarDTO(List<ItemPedidoDTO> lista) throws Exception {
        List<ItemPedido> items = produtoService.getList(lista);
        return items;
    }



    private double calValorDiario(List<Pedido> lista){
        double soma = 0;
        for (Pedido p: lista){
            soma+=p.getValor();
        }
        return soma;
    }
    private Double calcValor(List<ItemPedido> items){
        try {
            Double soma = 0.0;
            for (ItemPedido i : items) {
                soma += i.getProduto().getPreco() * i.getQuantidade();
            }
            return soma;
        }catch (NullPointerException exception){
            throw new NullPointerException("Variavel mal escrita");
        }
    }

    private String formListItems(Pedido p){
        List<ItemPedido> lista = p.getLista();
        String msg = "[";
        for (ItemPedido i : lista){
            if (lista.lastIndexOf(i)== lista.size()-1){
                msg += i.getProduto().getNome()+ " - Quantidade: " + i.getQuantidade() + " ] ";
                break;
            }
            msg+= i.getProduto().getNome() + " - Quantidade: " + i.getQuantidade() + ", ";
        }
        return msg;
    }

}
