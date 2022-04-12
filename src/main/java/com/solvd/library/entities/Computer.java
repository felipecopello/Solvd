package com.solvd.library.entities;

import com.solvd.library.util.ICalculate;

public class Computer {
	private int id;
	private String model;
	private String operatingSystem;

	public Computer() {
	};

	Computer(int id, String model, String operatingSystem) {
		setId(id);
		setModel(model);
		setOperatingSystem(operatingSystem);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int operate(Client a, Client b, ICalculate c) {
		return c.operation(a, b);
	}

}