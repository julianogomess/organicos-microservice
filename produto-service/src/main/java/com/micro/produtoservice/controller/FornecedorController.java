package com.micro.produtoservice.controller;


import com.micro.produtoservice.dto.FornecedorDTO;
import com.micro.produtoservice.model.Fornecedor;
import com.micro.produtoservice.service.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fornecedores")
@Api(value = "Gerenciamento de clientes")
@Slf4j
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;


    @ApiOperation(value = "Retorna todos os fornecedores na base")
    @GetMapping(value = "/listatodos")
    public List<Fornecedor> getTodosF(){
        log.info("Busca por todos os fornecedores");
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        if(fornecedores.isEmpty()){
            log.info("Nenhum fornecedor encontrado!");
            return fornecedores;
        }
        log.info(fornecedores.size()+ " fornecedores encontrados!");
        return fornecedores;
    }

    @ApiOperation(value = "Retorna os dados do fornecedor passando o cnpj")
    @GetMapping(value = "/buscaporcnpj/{cnpj}")
    public Fornecedor getByCnpj(@PathVariable String cnpj){
        log.info("Busca de fornecedor por CNPJ");
        Fornecedor fornecedor = fornecedorService.findByCnpj(cnpj);
        if (fornecedor==null){
            log.info("Fornecedor não encontrado");
            return null;
        }
        log.info("Fornecedor encontrado: " + fornecedor.getNome());
        return fornecedor;
    }
    @ApiOperation(value = "Realiza o cadastro do fornecedor")
    @PostMapping(value = "/cadastro")
    public Fornecedor cadastroFornecedor(@Valid @RequestBody FornecedorDTO fornecedor){
        log.info("Cadastro de novo fornecedor");
        return fornecedorService.save(fornecedor.transformar());
    }

    @ApiOperation(value = "Exclui o fornecedor por cnpj")
    @DeleteMapping(value = "/deleteporcnpj/{cnpj}")
    public ResponseEntity<Object> deleteByCnpj(@PathVariable String cnpj){
        Map<Object, Object> model = new HashMap<>();
        Fornecedor f = fornecedorService.findByCnpj(cnpj);
        if (f==null){
            log.info("Fornecedor não encontrado");
            model.put("message","Nenhum fornecedor encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
        }
        log.info("Fornecedor deletado! CNPJ: "+ cnpj);
        fornecedorService.deleteByCnpj(cnpj);
        model.put("message","Fornecedor deletado com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    @ApiOperation(value = "Edita o fornecedor")
    @PutMapping(value = "/atualizar/{cnpj}")
    public Fornecedor atualizarFornecedor(@PathVariable String cnpj, @RequestBody @Valid FornecedorDTO fornecedor){
        log.info("Busca do fornecedor para atualizar");
        Fornecedor f = fornecedorService.findByCnpj(cnpj);
        if (f==null){
            log.info("Fornecedor não encontrado");
            return null;
        }
        f = fornecedorService.atualizar(f,fornecedor);
        log.info("Fornecedor atualizado!");
        return f;
    }
}
