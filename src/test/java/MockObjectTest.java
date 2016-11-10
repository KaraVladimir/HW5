import entities.Car;
import entities.Fuel;
import entities.IForce;
import org.junit.Assert;
import org.junit.Test;
import proxy.FuelProxy;

import java.lang.reflect.Proxy;

/**
 * Test for FuelProxy
 * @see FuelProxy
 */
public class MockObjectTest {
    Car car = new Car("Skoda",3, 70);
    Fuel fuel = new Fuel(2);
    IForce iForce = (IForce) Proxy.newProxyInstance(fuel.getClass().getClassLoader(), fuel.getClass().getInterfaces(),
            new FuelProxy(fuel));

    @Test
    public void testFuel() {
        car.setFuel(iForce);
        Assert.assertEquals("",car.getForcedPower(),Integer.valueOf(140));

    }
}
