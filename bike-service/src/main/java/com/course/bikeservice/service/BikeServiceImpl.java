package com.course.bikeservice.service;

import com.course.bikeservice.entity.Bike;
import com.course.bikeservice.repository.IBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BikeServiceImpl implements IBikeService {

    @Autowired
    IBikeRepository repository;

    @Override
    public Flux<Bike> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Bike> getBikeById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Bike> save(Bike Bike) {
        return repository.save(Bike);
    }

    @Override
    public Mono<Bike> update(Bike Bike) {
        return repository.save(Bike);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

    @Override
    public Flux<Bike> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
