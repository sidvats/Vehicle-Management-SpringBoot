package com.example.main.model;

import java.io.Serializable;

public class Vehicle implements Serializable {

	private Integer id;

	private String model;

	private Double cost;

	private String company;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Integer id, String model, Double cost, String company) {
		super();
		this.id = id;
		this.model = model;
		this.cost = cost;
		this.company = company;
	}

	public Vehicle(String model, Double cost, String company) {
		super();
		this.model = model;
		this.cost = cost;
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", cost=" + cost + ", company=" + company + "]";
	}

}
