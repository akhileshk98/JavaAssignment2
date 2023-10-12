import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Getter methods for the private fields

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

public class CarManagementSystem {
    public static void main(String[] args) {
        // Create an array of Car objects
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 2018, "Red", 25000.0, "ABC123"));
        cars.add(new Car(2, "Honda", "Civic", 2017, "Blue", 22000.0, "XYZ456"));
        // Add more cars to the list as needed

        // Filter and save cars by brand
        saveCarsByBrand(cars, "Toyota", "ToyotaCars.txt");

        // Filter and save cars by model and age
        saveCarsByModelAndAge(cars, "Civic", 5, "OldCivicCars.txt");

        // Filter and save cars by year and price
        saveCarsByYearAndPrice(cars, 2018, 24000.0, "Expensive2018Cars.txt");
    }

    public static void saveCarsByBrand(List<Car> cars, String brand, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Car car : cars) {
                if (car.getMake().equalsIgnoreCase(brand)) {
                    writer.println(car.getId() + ", " + car.getMake() + ", " + car.getModel());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCarsByModelAndAge(List<Car> cars, String model, int years, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            int currentYear = 2023; // Current year
            for (Car car : cars) {
                if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture()) > years) {
                    writer.println(car.getId() + ", " + car.getMake() + ", " + car.getModel());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCarsByYearAndPrice(List<Car> cars, int year, double price, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Car car : cars) {
                if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                    writer.println(car.getId() + ", " + car.getMake() + ", " + car.getModel());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
