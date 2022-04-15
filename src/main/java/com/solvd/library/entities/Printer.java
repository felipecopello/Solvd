package com.solvd.library.entities;

import com.solvd.library.util.IPrintable;

public class Printer {
	private int id;
	private String model;
	private String toPrint;

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

	public String getToPrint() {
		return toPrint;
	}

	public void setToPrint(String toPrint) {
		this.toPrint = toPrint;
	}

	public void printThing(IPrintable<String> thing) {
		thing.print(toPrint);
	}

}