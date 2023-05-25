package com.tutorial.userservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

	private String userName;
	private List<Car> cars;
	private List<Bike> bikes;
}
