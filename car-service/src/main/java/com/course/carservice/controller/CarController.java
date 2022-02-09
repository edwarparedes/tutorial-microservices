package com.course.carservice.controller;

import com.course.carservice.entity.Car;
import com.course.carservice.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    ICarService service;

    @GetMapping
    public Flux<Car> getCars(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Car> getCarById(@PathVariable("id") String id){
        return service.getCarById(id);
    }

    @PostMapping
    Mono<Car> postCar(@RequestBody Car car){
        return service.save(car);
    }

    @PutMapping
    Mono<Car> updCar(@RequestBody Car car){
        return service.update(car);
    }

    @DeleteMapping("/{id}")
    void dltCar(@PathVariable("id") String id){
        service.delete(id);
    }

    @GetMapping("/byUser/{userId}")
    public Flux<Car> getByUserId(@PathVariable("userId") String userId){
        return service.getByUserId(userId);
    }

}
