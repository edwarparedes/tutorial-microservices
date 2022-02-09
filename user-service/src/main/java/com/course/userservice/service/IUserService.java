package com.course.userservice.service;

import com.course.userservice.entity.User;
import com.course.userservice.model.Bike;
import com.course.userservice.model.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    Flux<User> getAll();

    Mono<User> getUserById(String id);

    Mono<User> save(User user);

    Mono<User> update(User user);

    void delete(String id);

    Flux<Car> getCars(String id);

    Flux<Bike> getBikes(String id);
}
