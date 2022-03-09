package com.micro.produtoservice.service.fornecedor;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface FornecedorService {
    boolean checkCnpj(String cnpj) throws ExecutionException, JsonProcessingException, InterruptedException, TimeoutException, Exception;
}
