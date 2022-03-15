package com.micro.produtoservice.repository;

import com.micro.produtoservice.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FornecedorRepository extends MongoRepository<Fornecedor,String> {
    Fornecedor findByCnpj(String cnpj);
    void deleteByCnpj(String cnpj);
}
