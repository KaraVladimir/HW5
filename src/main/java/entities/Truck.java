package entities;

import annotations.PrintsStringFromMethod;

/**
 * Class represents Truck
 * @author Kara V.
 * @see Car
 */
public class Truck extends Car {
    private Integer loadedWeight;
    private String model = "C";

    public Truck() {
    }

    public Truck(String model, Integer numberOfCylinders, Integer power, Integer loadedWeight) {
        super(model, numberOfCylinders, power);
        this.loadedWeight = loadedWeight;
    }

    public Integer getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(Integer loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    @PrintsStringFromMethod
    public String toString() {
        return String.format("Truck{model: %s, number of cylinders: %d,power: %d,loaded weight: %d}",
                getModel(), getNumberOfCylinders(), getPower(),getLoadedWeight());
    }
}
