package entities;

/**
 * Interface is used for dynamic proxy
 */
public interface ICar {
    String getModel();

    void setModel(String model);

    Integer getNumberOfCylinders();

    void setNumberOfCylinders(Integer numberOfCylinders);

    Integer getPower();

    void setPower(Integer power);
}
