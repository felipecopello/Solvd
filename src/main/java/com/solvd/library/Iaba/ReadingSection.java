package com.solvd.library.Iaba;

public class ReadingSection {
	private int chairs;
	private int tables;
	private int beanBags;

	ReadingSection() {
	}

	ReadingSection(int chairs, int tables, int beanBags) {
		setChairs(chairs);
		setTables(tables);
		setBeanBags(beanBags);
	}

	public int getChairs() {
		return chairs;
	}

	public void setChairs(int chairs) {
		this.chairs = chairs;
	}

	public int getTables() {
		return tables;
	}

	public void setTables(int tables) {
		this.tables = tables;
	}

	public int getBeanBags() {
		return beanBags;
	}

	public void setBeanBags(int beanBags) {
		this.beanBags = beanBags;
	}

}