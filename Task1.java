class Car {

    String model;
    double price;

    Car() {
        this("Unknown");
        System.out.println("No-arg constructor executed");
    }

    Car(String model) {
        this(model, 0.0);
        System.out.println("One-arg constructor executed");
    }

    Car(String model, double price) {
        this.model = model;
        this.price = price;
        System.out.println("Two-arg constructor executed");
    }

    void showDetails() {
        System.out.println("Model: " + model + ", Price: " + price);
    }
}


public class Task1 {

	public static void main(String[] args) {
		
		System.out.println("\nCreating Car 1:");
        Car c1 = new Car();
        c1.showDetails();

        System.out.println("\nCreating Car 2:");
        Car c2 = new Car("Honda City");
        c2.showDetails();

        System.out.println("\nCreating Car 3:");
        Car c3 = new Car("BMW X5", 6000000);
        c3.showDetails();
	}

}
