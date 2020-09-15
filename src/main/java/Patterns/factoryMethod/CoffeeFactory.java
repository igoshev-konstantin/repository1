package Patterns.factoryMethod;

class SimpleCoffeeFactory {
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee;
        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
            case CAFFE_LATTE:
                coffee = new CaffeLatte();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return coffee;
    }
}

class CoffeeShopFactory{
    private final SimpleCoffeeFactory coffeeFactory;

    public CoffeeShopFactory(SimpleCoffeeFactory coffeeFactory){
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        return coffee;
    }


}
