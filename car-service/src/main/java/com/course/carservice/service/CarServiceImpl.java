package com.course.carservice.service;

import com.course.carservice.entity.Car;
import com.course.carservice.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    ICarRepository repository;

    @Override
    public Flux<Car> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Car> getCarById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Car> save(Car Car) {
        return repository.save(Car);
    }

    @Override
    public Mono<Car> update(Car Car) {
        return repository.save(Car);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

    @Override
    public Flux<Car> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
