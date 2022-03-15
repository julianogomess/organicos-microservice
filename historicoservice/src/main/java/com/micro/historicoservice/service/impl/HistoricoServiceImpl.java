package com.micro.historicoservice.service.impl;

import com.micro.historicoservice.model.HistHelper;
import com.micro.historicoservice.model.Historico;
import com.micro.historicoservice.repository.HistoricoRepository;
import com.micro.historicoservice.service.HistoricoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    HistoricoRepository repository;


    @Override
    public List<Historico> findAll() {
        return repository.findAll();
    }

    @Override
    public Historico findById(String id) {
        Optional<Historico> h = repository.findById(id);
        if(h.isPresent()){
            return h.get();
        }
        return null;
    }

    @Override
    public Historico save(Historico historico) {
        return repository.save(historico);
    }

    @Override
    public void delete(Historico historico) {
        repository.delete(historico);
    }


}
