package com.solvd.library.enums;

public enum Course {

	READING_FOR_BEGGINERS {
		@Override
		public void info() {
			System.out.println("Reading for begginers is on " + Day.TUESDAY + " and " + Day.THURSDAY + " in "
					+ Room.ROOM_1.getName());
		}
	},
	NOVELS_CLUB {
		@Override
		public void info() {
			System.out.println(
					"Novels reading club is on " + Day.MONDAY + " and " + Day.FRIDAY + " in " + Room.ROOM_2.getName());
		}
	},
	WRITING {
		@Override
		public void info() {
			System.out.println("Writing lessons are on " + Day.WEDNESDAY + " and " + Day.SATURDAY + " in "
					+ Room.CONFERENCE_ROOM.getName());
		}
	};

	public abstract void info();
}