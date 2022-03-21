package library;

public class SecurityGuard extends People implements IHelp, IWork, IGreet {
	public SecurityGuard() {
	}

	public SecurityGuard(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void helpClient() {
		System.out.format("%nThe section you are looking for is that way");
	}

	@Override
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
		guard1.greet(guard1.getName());

		IHelp g = new SecurityGuard();
		g.helpClient();
	}
}