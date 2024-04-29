package com.example.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.main.model.Vehicle;
import com.example.main.repository.VehicleRepository;

@Service
/**
 * 
 * @author spavanku
 * class description goes here
 *
 */
public class VehicleService implements IVehicleService {

	
	VehicleRepository repository;
	
	public VehicleService() {
		repository = new VehicleRepository();
	}

	/**
	 * method comments
	 */
	@Override
	public Vehicle getVehicle(int id) {
		return repository.findVehicleById(id);
	}

	/**
	 * method comments
	 */
	@Override
	public List<Vehicle> getAllVehicles() {
		return repository.findAllVehicles();
	}

	/**
	 * method comments
	 */
	@Override
	public List<Vehicle> addVehicle(Vehicle vehicle) {
		return repository.addVehicle(vehicle);
	}

	/**
	 * method comments
	 */
	@Override
	public List<Vehicle> getAllModels(String company) {
		return repository.findAllByCompany(company);
	}

	/**
	 * method comments
	 */
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return repository.updateVehicle(vehicle);
	}

	@Override
	public List<Vehicle> deleteVehicle(int id) {
		repository.deleteById(id);
		return repository.findAllVehicles();
	}

}
