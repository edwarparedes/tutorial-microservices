package com.course.carservice.repository;

import com.course.carservice.entity.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICarRepository extends ReactiveMongoRepository<Car, String> {
    //Flux<ClientEntity> findByDocNumber(int docNumber); // 2 Metodo para realizar el filtro por numero de documento

    Flux<Car> findByUserId(String userId);
}
