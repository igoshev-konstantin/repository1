package Spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


enum CarsType {TOYOTA, HONDA, NISSAN, TRUCK, UNKNOWN}

public class Annotations {
    private static final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

    public static void main(String[] args) {
      //  newCarFactory();
        newOrder();
    }

    public static void newCarFactory() {
        int RandomTypeNumber = (int) (Math.random() * 3);
        CarsType carType = CarsType.values()[RandomTypeNumber];
        CarsFactory carsFactory = context.getBean("carsFactory", CarsFactory.class);
        System.out.println("Made new car: " + carsFactory.MadeCar(carType).getCarType());
        context.close();
    }

    public static void newOrder() {
        Customer customer = context.getBean("customer", Customer.class);
        System.out.println("Ordered car:"+customer.getOrderedCar().getCarType());
        context.close();
    }
}

@Component
class CarsFactory {

    public Car MadeCar(CarsType carsType) {

        switch (carsType) {
            case TOYOTA:
                return new Car(CarsType.TOYOTA);
            case HONDA:
                return new Car(CarsType.HONDA);
            case NISSAN:
                return new Car(CarsType.NISSAN);
        }
        return null;
    }
}

@Component
class Car implements CarsInterface{
    private CarsType carType;

    public Car() {
        int RandomTypeNumber = (int) (Math.random() * 3);
        this.carType = CarsType.values()[RandomTypeNumber];
    }

    public Car(CarsType carType) {
        this.carType = carType;
    }

    public CarsType getCarType() {
        return carType;
    }

}

//@Component    //Если 2 одинаковых бина, то при Autowired Spring-у будет непонятно какой из них выбрать
class Truck implements CarsInterface{
    private CarsType carType;

    public Truck() {}

    public CarsType getCarType() {
        return carType;
    }
}

@Component
class Customer {
    private final CarsInterface orderedCar;

    @Autowired
    public Customer(CarsInterface orderedCar) {
        this.orderedCar = orderedCar;
    }
    public CarsInterface getOrderedCar(){
        return orderedCar;
    }
}
//@Component
//class Customer {
//    private final Car orderedCar;
//
//    @Autowired
//    public Customer(Car orderedCar) {
//        this.orderedCar = orderedCar;
//    }
//    public Car getOrderedCar(){
//        return orderedCar;
//    }
//}