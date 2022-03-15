package com.micro.historicoservice.repository;

import com.micro.historicoservice.model.HistHelper;
import com.micro.historicoservice.model.Historico;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends MongoRepository<Historico,String> {

    @Aggregation(pipeline = {"{$match:{$and:[ {enviado:?0},{realizado:?1}]}}"
            ,"{$group: { _id: '$email', total: {$sum: 1}}}"
            , "{ $sort : {total : -1}}"})
    List<HistHelper> getHistByTipo(Boolean enviado, Boolean realizado);

    @Query("{$and:[{email:?0},{enviado:?1}]}")
    List<Historico> getPesquisasPorEmail(String email,Boolean enviado);
}
