package com.tutorial.userservice.controller;

import com.tutorial.userservice.clients.BikeClient;
import com.tutorial.userservice.clients.CarClient;
import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.model.Bike;
import com.tutorial.userservice.model.Car;
import com.tutorial.userservice.model.Consumer;
import com.tutorial.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    CarClient carClient;
    
    @Autowired
    BikeClient bikeClient;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        User userNew = userService.save(user);
        return ResponseEntity.ok(userNew);
    }

    
    @GetMapping("/consumer/byuser/{userId}")
    public ResponseEntity<Consumer> getProductsByUserId(@PathVariable("userId") int id) {
    	
    	List<Bike> bikes = bikeClient.getByUserId(id).getBody();
    	List<Car> cars = carClient.getByUserId(id).getBody();
    	User user = userService.getUserById(id);
    	
    	if (user == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	Consumer consumer = new Consumer();
    	consumer.setUserName(user.getName());
    	consumer.setBikes(bikes);
    	consumer.setCars(cars);
    	
    	return ResponseEntity.ok(consumer);
    }
    
    
}
