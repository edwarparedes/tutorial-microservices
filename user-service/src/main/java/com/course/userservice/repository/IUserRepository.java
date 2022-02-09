package com.course.userservice.repository;

import com.course.userservice.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
    //Flux<ClientEntity> findByDocNumber(int docNumber); // 2 Metodo para realizar el filtro por numero de documento
}
