package clase3;

class Plane {
	private String model;
	private int size;
	private int speed;

	public Plane() {
	};

	public Plane(int size, String model, int speed) {
		this.size = size;
		this.model = model;
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public String getModel() {
		return model;
	}

	public int getSize() {
		return size;
	}

	public void setModel(String newModel) {
		this.model = newModel;
	}

	public void setSize(int newSize) {
		this.size = newSize;
	}

	public static void main(String[] args) {
		Plane plane = new Plane(55, "boing", 500); // Create an object of class (This will call the constructor)
		System.out.println("el avion mide: " + plane.getSize());
		System.out.println(plane.getModel());
		plane.setSize(555);
		System.out.println("el avion ahora mide: " + plane.getSize());
		Plane plane1 = new Plane(87, "boing", 600);
		System.out.println("el avion 1 es el: " + plane1.getModel() + " su capacidad es " + plane1.getSize()
				+ " su velocidad es " + plane1.getSpeed());

	}

}
