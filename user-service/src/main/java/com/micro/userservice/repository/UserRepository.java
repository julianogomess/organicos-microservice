package com.micro.userservice.repository;

import com.micro.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
    User findByCpf(String cpf);
    void deleteByCpf(String cpf);

}