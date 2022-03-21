package library;

public class Janitor extends People implements IHelp, IWork {
	public Janitor() {
	};

	public Janitor(String name, int age, int id) {
		super(name, age, id);
	}

	public void work() {
		System.out.format("%nCleaning the library");
	}

	public void helpClient() {
		System.out.format("%nThe book you are looking for is over here");
	}

	public static void main(String[] args) {
		IHelp j = new Janitor();
		j.helpClient();

		Janitor janitor1 = new Janitor("Esteban Perez", 62, 7895587);
		janitor1.work();

	}
}