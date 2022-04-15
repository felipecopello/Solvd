package com.solvd.library.entities;

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

}