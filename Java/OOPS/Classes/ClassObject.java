package Java.OOPS.Classes;

// Defining the Car class
class Car {
  // Instance variables
  String make;
  String model;
  int year;
  int price;
  int seats;

  // Constructor to initialize the Car object
  public Car(String make, String model, int year, int price, int seats) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.seats = seats;
  }

  // Method to display car information
  public void displayInfo() {
    System.out.println("Car make: " + make);
    System.out.println("Car model: " + model);
    System.out.println("Car year: " + year);
    System.out.println("Car price: " + price);
    System.out.println("Car seats: " + seats);
  }
}

// Main class to demonstrate the Car class
public class ClassObject {

  public static void main(String[] args) {
    // Creating objects of Car class

    Car car1 = new Car("Toyota", "Camry", 2020, 100000, 5);
    Car car2 = new Car("Ford", "Mustang", 2018, 80000, 2);

    // Accessing and modifying object properties
    car1.displayInfo();
    System.out.println();
    car2.displayInfo();
  }
}
