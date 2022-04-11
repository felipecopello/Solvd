package com.solvd.library.entities;

import com.solvd.library.util.IPrintable;

public class Printer {
	private int id;
	private String model;

	public Printer() {
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

	public static void printThing(IPrintable thing) {
		thing.print();
	}

}