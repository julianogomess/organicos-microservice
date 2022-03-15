package com.micro.historicoservice.service;


import com.micro.historicoservice.model.Historico;

import java.util.List;

public interface HistoricoService {
    List<Historico> findAll();
    Historico findById(String id);
    Historico save(Historico historico);
    void delete(Historico historico);
}
