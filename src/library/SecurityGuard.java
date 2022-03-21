package library;

public class SecurityGuard extends People implements IHelp, IWork {
	public SecurityGuard() {
	}

	public SecurityGuard(String name, int age, int id) {
		super(name, age, id);
	}

	public void helpClient() {
		System.out.format("%nThe section you are looking for is that way");
	}

	public void work() {
		System.out.format("%nWatching the library");
	}

	public void beQuiet() {
		System.out.println("Please be quiet in the library");
	}

	public static void main(String[] args) {
		SecurityGuard guard1 = new SecurityGuard("Pedro Sanches", 55, 665894);
		guard1.beQuiet();
		guard1.helpClient();
		guard1.work();

		IHelp g = new SecurityGuard();
		g.helpClient();
	}
}