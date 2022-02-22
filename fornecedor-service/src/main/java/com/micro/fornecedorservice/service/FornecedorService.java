package com.micro.fornecedorservice.service;

import com.micro.fornecedorservice.dto.FornecedorDTO;
import com.micro.fornecedorservice.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    Fornecedor save(Fornecedor f);
    List<Fornecedor> findAll();
    Fornecedor findByCnpj(String cnpj);
    void deleteByCnpj(String cnpj);
    Fornecedor atualizar(Fornecedor f, FornecedorDTO dto);
}