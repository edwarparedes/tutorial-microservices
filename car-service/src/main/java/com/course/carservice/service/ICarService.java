package com.course.carservice.service;

import com.course.carservice.entity.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICarService {

    Flux<Car> getAll();

    Mono<Car> getCarById(String id);

    Mono<Car> save(Car car);

    Mono<Car> update(Car car);

    void delete(String id);

    Flux<Car> getByUserId(String userId);
}
