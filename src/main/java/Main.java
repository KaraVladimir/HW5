import annotations.PrintsStringFromMethod;
import entities.Car;
import entities.ICar;
import entities.Truck;
import proxy.CarProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for this project
 */
public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Audi", 4, 120));
        cars.add(new Truck("Man", 12,450,10000));
        testDynamicProxy(new Car("BMW", 4, 120));
        //annotationTest(cars);
        //reflectionTest(cars);
    }

    /**
     * This method was written for test dynamic proxy abilities
     * @param car
     */
    private static void testDynamicProxy(Car car) {
        ICar iCar = (ICar) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                car.getClass().getInterfaces(), new CarProxy(car));
        System.out.println(iCar.getModel());
        iCar.setModel("Ren");
    }

    /**
     * This method was written for test Reflection abilities
     * @param cars
     */
    private static void reflectionTest(List<Car> cars) {
        for (Car car:cars) {
            printListOfInterfaces(car);
            printListOfFields(car);
        }
    }

    /**
     * This method was written for test annotation PrintStringFromMethod
     * @see PrintsStringFromMethod
     * @param cars
     */
    private static void annotationTest(List<Car> cars) {
        for (Car car:cars) {
            try {
                printsStringFromMethod(car);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method gets object and prints all interfaces it implements
     * @param object
     */
    private static void printListOfInterfaces(Object object) {
        Class[] classes = object.getClass().getInterfaces();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getCanonicalName()).append(" implements:");
        if (classes.length > 0) {
            for (Class aClass : classes) {
                stringBuilder.append(aClass.getCanonicalName()).append(';');
            }
        } else {
            stringBuilder.append("nothing");
        }
        System.out.println(stringBuilder);
    }

    /**
     * his method gets object and prints all fields with type and annotations
     * @param object
     */
    private static void printListOfFields(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getName()).append(" have fields:");
        for (Field field : fields) {
            field.setAccessible(true);
            stringBuilder.append(" name:").append(field.getName()).append(" type:").
                    append(field.getType().getSimpleName());
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length > 0) {
                stringBuilder.append(" @:");
                for (Annotation annotation : annotations) {
                    stringBuilder.append(annotation.annotationType().getSimpleName());
                }
            }
            stringBuilder.append(';');
        }
        System.out.println(stringBuilder);
    }

    /**
     * This method gets an object and prints annotated fields
     * @param object
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @see PrintsStringFromMethod
     */
    private static void printsStringFromMethod(Object object)
            throws InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method:methods) {
            if (method.isAnnotationPresent(PrintsStringFromMethod.class)) {
                method.setAccessible(true);
                if (method.getReturnType()==String.class&&method.getParameters().length==0) {
                    System.out.println(method.invoke(object));
                }
            }
        }
    }
}
