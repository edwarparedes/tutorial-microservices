package com.course.userservice.controller;

import com.course.userservice.entity.User;
import com.course.userservice.model.Bike;
import com.course.userservice.model.Car;
import com.course.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping
    public Flux<User> getUsers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable("id") String id){
        return service.getUserById(id);
    }

    @PostMapping
    Mono<User> postUser(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping
    Mono<User> updUser(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    void dltUser(@PathVariable("id") String id){
        service.delete(id);
    }


    @GetMapping("/cars/{userId}")
    public Flux<Car> getCars(@PathVariable("userId") String userId){
        return service.getCars(userId);
    }

    @GetMapping("/bikes/{userId}")
    public Flux<Bike> getBikes(@PathVariable("userId") String userId){
        return service.getBikes(userId);
    }

}
