package proxy;

import entities.Fuel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This class creates dynamic proxy for class Fuel
 * @see Fuel
 */
public class FuelProxy implements InvocationHandler {

    private Object object;

    public FuelProxy(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Deforced power:"+args[0]);
        return method.invoke(object, args);
    }
}
