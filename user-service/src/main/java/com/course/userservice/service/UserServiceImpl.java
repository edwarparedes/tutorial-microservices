package com.course.userservice.service;

import com.course.userservice.entity.User;
import com.course.userservice.model.Bike;
import com.course.userservice.model.Car;
import com.course.userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repository;

    WebClient webClientCar = WebClient.builder().baseUrl("http://localhost:8002").build();

    WebClient webClientBike = WebClient.builder().baseUrl("http://localhost:8003").build();

    //@Autowired
    //RestTemplate restTemplate;

    @Override
    public Flux<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<User> getUserById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(user);
    }

    @Override
    public Mono<User> update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

    @Override
    public Flux<Car> getCars(String userId) {
        //return restTemplate.getForObject("http://localhost:8002/car/byUser/" + userId, Flux.class);
        Flux<Car> carFlux = webClientCar
                .get()
                .uri("/car/byUser/{userId}", userId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Car.class);
        return carFlux;
    }

    @Override
    public Flux<Bike> getBikes(String userId) {
        //return restTemplate.getForObject("http://localhost:8003/bike/byUser/" + userId, Flux.class);
        Flux<Bike> bikeFlux = webClientBike
                .get()
                .uri("/bike/byUser/{userId}", userId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Bike.class);
        return bikeFlux;
    }
}
