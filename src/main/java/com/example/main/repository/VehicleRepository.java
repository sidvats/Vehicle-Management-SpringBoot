package com.example.main.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.main.model.Vehicle;

public class VehicleRepository {

	static List<Vehicle> list = null;

	static {
		list = new ArrayList<>();
		list.add(new Vehicle(100, "Alto", 650000d, "Maruti"));
		list.add(new Vehicle(101, "xylo", 850000d, "Honda"));
		list.add(new Vehicle(102, "celtos", 950000d, "Kia"));
		list.add(new Vehicle(103, "Figo Aspire", 750000d, "Ford"));
		list.add(new Vehicle(104, "Nexon", 950000d, "Tata"));
		list.add(new Vehicle(105, "K10", 650000d, "Maruti"));
	}

	public List<Vehicle> findAllVehicles() {
		return list;
	}

	public List<Vehicle> addVehicle(Vehicle vehicle) {
		list.add(vehicle);
		return list;
	}

	public Vehicle findVehicleById(int id) {

		Vehicle vehicle = null;

		for (Vehicle myVehicle : list) {
			if (myVehicle.getId() == id) {
				vehicle = myVehicle;
				break;
			}
		}
		return vehicle;
	}

	public List<Vehicle> deleteById(int id) {

		for (Vehicle myVehicle : list) {
			if (myVehicle.getId() == id) {
				list.remove(myVehicle);
				break;
			}
		}
		return findAllVehicles();
	}

	public Vehicle updateVehicle(Vehicle vehicle) {

		int index = 0;
		Vehicle vehicleData = null;
		for (Vehicle myVehicle : list) {
			if (myVehicle.getId() == vehicle.getId()) {
				index = list.indexOf(myVehicle);
				myVehicle.setCost(vehicle.getCost());
				myVehicle.setCompany(vehicle.getCompany());
				myVehicle.setModel(vehicle.getModel());
				list.set(index, myVehicle);
				vehicleData = myVehicle;
				break;
			}
		}
		return vehicleData;
	}

	public List<Vehicle> findAllByCompany(String company) {

		List<Vehicle> vehiclesList = new ArrayList<>();

		for (Vehicle vehicle : list) {
			if (vehicle.getCompany().equals(company)) {
				vehiclesList.add(vehicle);
			}
		}
		return vehiclesList;
	}

}
