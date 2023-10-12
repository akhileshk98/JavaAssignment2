import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double price;

    public Car(String make, String model, int yearOfManufacture, double price) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture + ", Price: " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2019, 25000.0));
        cars.add(new Car("Honda", "Civic", 2018, 22000.0));
        cars.add(new Car("Toyota", "Corolla", 2017, 18000.0));

        saveCarsByBrand(cars, "Toyota", "ToyotaCars.txt");
        saveCarsByModelAndAge(cars, "Camry", 3, "CamryCars.txt");
        saveCarsByYearAndPrice(cars, 2018, 20000.0, "Expensive2018Cars.txt");
    }

    public static void saveCarsByBrand(List<Car> cars, String brand, String filename) {
        List<Car> brandCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(brand)) {
                brandCars.add(car);
            }
        }
        saveCarsToFile(brandCars, filename);
    }

    public static void saveCarsByModelAndAge(List<Car> cars, String model, int minAge, String filename) {
        List<Car> modelCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.getYearOfManufacture() + minAge <= 2023) {
                modelCars.add(car);
            }
        }
        saveCarsToFile(modelCars, filename);
    }

    public static void saveCarsByYearAndPrice(List<Car> cars, int year, double minPrice, String filename) {
        List<Car> yearCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > minPrice) {
                yearCars.add(car);
            }
        }
        saveCarsToFile(yearCars, filename);
    }

    public static void saveCarsToFile(List<Car> cars, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.println(car.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
