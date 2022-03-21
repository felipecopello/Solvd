package library;

interface IWork {
	default void work() {
		System.out.format("%nPerforming a job");
	}
}