package com.micro.produtoservice.service.impl;


import com.micro.produtoservice.dto.FornecedorDTO;
import com.micro.produtoservice.gateway.model.ItemPedido;
import com.micro.produtoservice.gateway.model.ItemPedidoDTO;
import com.micro.produtoservice.model.Fornecedor;
import com.micro.produtoservice.model.Produto;
import com.micro.produtoservice.model.Tipo;
import com.micro.produtoservice.repository.FornecedorRepository;
import com.micro.produtoservice.repository.ProdutoRepository;
import com.micro.produtoservice.service.FornecedorService;
import com.micro.produtoservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    FornecedorRepository fr;

    @Override
    public Fornecedor save(Fornecedor f) {
        return fr.save(f);
    }

    @Override
    public List<Fornecedor> findAll() {
        return fr.findAll();
    }

    @Override
    public Fornecedor findByCnpj(String cnpj) {
        return fr.findByCnpj(cnpj);
    }

    @Override
    public void deleteByCnpj(String cnpj) {
        fr.deleteByCnpj(cnpj);
    }

    @Override
    public Fornecedor atualizar(Fornecedor f, FornecedorDTO dto) {
        f.setEmail(dto.getEmail());
        f.setCnpj(dto.getCnpj());
        f.setTelefone(dto.getTelefone());
        f.setEndereco(dto.getEndereco());
        f.setNome(dto.getNome());
        return fr.save(f);
    }

    @Override
    public boolean checkCnpj(String cnpj) {
        Fornecedor f = this.findByCnpj(cnpj);
        if (f==null){
            return false;
        }
        return true;
    }

}
