package entities;

/**
 * this class represents Fuel for Car
 * @author Kara V.
 * @see Car
 */
public class Fuel implements IForce{
    private Integer detonation;

    public Fuel(Integer detonation) {
        this.detonation = detonation;
    }

    public Integer forceEngine(Integer power) {
        return detonation*power;
    }
}
