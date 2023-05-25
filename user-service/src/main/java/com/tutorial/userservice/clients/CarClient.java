package com.tutorial.userservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tutorial.userservice.model.Car;

@FeignClient(name="car-service")
public interface CarClient {
	
	@GetMapping("/car")
    public ResponseEntity<List<Car>> getAll();

	@GetMapping("/car/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id);
	
	@PostMapping("/car")
    public ResponseEntity<Car> save(@RequestBody Car car);
	
	@GetMapping("/car/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId);
}
