package com.example.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.exceptions.VehicleNotFoundException;
import com.example.main.model.Vehicle;
import com.example.main.service.IVehicleService;
import com.example.main.service.VehicleService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MyRestController {

	IVehicleService service;

	public MyRestController() {
		service = new VehicleService();
	}

	@GetMapping("/getVehicles/{company}")
	public ResponseEntity<List<Vehicle>> getVehicle(@PathVariable String company) {
		List<Vehicle> vehicles = service.getAllModels(company);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/getVehicle/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") int id) {

		Vehicle vehicle = service.getVehicle(id);
		if (vehicle == null) {
			throw new VehicleNotFoundException("No Vehicle present with the given id: " + id);
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@GetMapping("/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getVehicles() throws Exception {
		List<Vehicle> vehicles = service.getAllVehicles();

		/*
		 * if(vehicles.size() > 0) { throw new Exception("We have more vehicles"); }
		 */

		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@PostMapping("/addVehicle")
	public List<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		List<Vehicle> vehicleInfo = service.addVehicle(vehicle);
		return vehicleInfo;
	}

	@PutMapping("/Sprintboot-rest-demo/updateVehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
		//vehicle.setId(id);
		Vehicle vehicleInfo = service.updateVehicle(vehicle);
		return new ResponseEntity<Vehicle>(vehicleInfo, HttpStatus.OK);
	}

	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<List<Vehicle>> deleteVehicle(@PathVariable int id) {
		List<Vehicle> vehicles = service.deleteVehicle(id);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

}
