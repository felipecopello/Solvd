package library;

interface IRead {
	default void read() {
		System.out.format("%nReading...");
	}
}