package com.tutorial.userservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tutorial.userservice.model.Bike;


@FeignClient(name="bike-service")
public interface BikeClient {
	
	 @GetMapping("/bike")
	 public ResponseEntity<List<Bike>> getAll();
	 
	 @GetMapping("/bike/{id}")
	 public ResponseEntity<Bike> getById(@PathVariable("id") int id);
	 
	 @PostMapping("/bike")
	 public ResponseEntity<Bike> save(@RequestBody Bike bike);
	 
	 @GetMapping("/bike/byuser/{userId}")
	 public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId);

}
