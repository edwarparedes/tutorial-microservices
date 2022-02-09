package com.course.bikeservice.repository;

import com.course.bikeservice.entity.Bike;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IBikeRepository extends ReactiveMongoRepository<Bike, String> {
    //Flux<ClientEntity> findByDocNumber(int docNumber); // 2 Metodo para realizar el filtro por numero de documento

    Flux<Bike> findByUserId(String userId);
}
