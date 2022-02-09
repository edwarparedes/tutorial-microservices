package com.course.bikeservice.service;

import com.course.bikeservice.entity.Bike;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBikeService {

    Flux<Bike> getAll();

    Mono<Bike> getBikeById(String id);

    Mono<Bike> save(Bike Bike);

    Mono<Bike> update(Bike Bike);

    void delete(String id);

    Flux<Bike> getByUserId(String userId);
}
