import entities.Car;
import entities.ICar;
import entities.Truck;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import proxy.CarProxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * Testing dynamic proxy for immutable object
 */
public class DynamicProxyTest {
    Car car = new Car("Audi", 4, 120);
    ICar iCar = (ICar) Proxy.newProxyInstance(car.getClass().getClassLoader(),
            car.getClass().getInterfaces(), new CarProxy(car));

    @Test
    public void testGetMethod() {
        Assert.assertEquals("",iCar.getModel(),"Audi");
    }

    @Test(expected = UndeclaredThrowableException.class)
    public void testSetMethod() {
        iCar.setModel("Renault");
    }
}

