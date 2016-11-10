package entities;

import annotations.PrintsStringFromMethod;

import java.io.Serializable;

/**
 * Class represents Car
 * @author Kara V.
 */
public class Car implements ICar{
    private String model;
    private Integer numberOfCylinders;
    private Integer power;
    private IForce fuel;

    public Car() {
    }

    public Car(String model, Integer numberOfCylinders, Integer power) {
        this.model = model;
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(Integer numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public IForce getFuel() {
        return fuel;
    }

    public void setFuel(IForce fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return String.format("Car{model: %s, number of cylinders: %d,power: %d}",
                getModel(), getNumberOfCylinders(), getPower());
    }

    /**
     *Method for test
     */
    @PrintsStringFromMethod
    private String probe(String s) {
        String o = s;
        return "OK";
    }

    public Integer getForcedPower() {
        return fuel.forceEngine((fuel!=null)?getPower():1);
    }
}
