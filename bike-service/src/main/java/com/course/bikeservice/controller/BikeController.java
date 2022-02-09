package com.course.bikeservice.controller;

import com.course.bikeservice.entity.Bike;
import com.course.bikeservice.service.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    IBikeService service;

    @GetMapping
    public Flux<Bike> getBikes(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Bike> getBikeById(@PathVariable("id") String id){
        return service.getBikeById(id);
    }

    @PostMapping
    Mono<Bike> postBike(@RequestBody Bike Bike){
        return service.save(Bike);
    }

    @PutMapping
    Mono<Bike> updBike(@RequestBody Bike Bike){
        return service.update(Bike);
    }

    @DeleteMapping("/{id}")
    void dltBike(@PathVariable("id") String id){
        service.delete(id);
    }

    @GetMapping("/byUser/{userId}")
    public Flux<Bike> getByUserId(@PathVariable("userId") String userId){
        return service.getByUserId(userId);
    }

}
