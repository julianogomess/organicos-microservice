package com.micro.pedidosservice.repository;

import com.micro.pedidosservice.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido,String> {
    List<Pedido> findByCpfCliente(String cpf);

    Optional<Pedido> findById(String id);

    @Query("{finalizado:?0}")
    List<Pedido> getPedidosByFinalizado(Boolean finalizado);

    @Query("{data:{$gt:?0}}")
    List<Pedido> getPedidoDeHoje(Date data);
}
