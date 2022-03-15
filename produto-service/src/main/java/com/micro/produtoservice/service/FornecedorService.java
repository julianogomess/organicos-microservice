package com.micro.produtoservice.service;


import com.micro.produtoservice.dto.FornecedorDTO;
import com.micro.produtoservice.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    Fornecedor save(Fornecedor f);
    List<Fornecedor> findAll();
    Fornecedor findByCnpj(String cnpj);
    void deleteByCnpj(String cnpj);
    Fornecedor atualizar(Fornecedor f, FornecedorDTO dto);
    boolean checkCnpj(String cnpj);
}