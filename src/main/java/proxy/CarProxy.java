package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This class is dynamic proxy
 */
public class CarProxy implements InvocationHandler {

    private Object object;

    public CarProxy(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("set".equals(method.getName().substring(0, 3))) {
            throw new Throwable("Method "+method.getName()+" was denied.This is immutable object");
        }
        return method.invoke(object,args);
    }
}
