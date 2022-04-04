package com.solvd.library.Iaba;

public class Printer {
	private int id;
	private String model;

	Printer() {
	};

	Printer(int id, String model) {
		setId(id);
		setModel(model);
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
}