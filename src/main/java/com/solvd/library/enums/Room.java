package com.solvd.library.enums;

enum Room {
	ROOM_1("Room 1"), ROOM_2("Room 2"), CONFERENCE_ROOM("Conference room");

	private final String name;

	Room(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}