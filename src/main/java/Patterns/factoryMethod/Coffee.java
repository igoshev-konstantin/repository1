package Patterns.factoryMethod;

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

class Coffee {
    public void grindCoffee() {
        // перемалываем кофе
    }

    public void makeCoffee() {
        // делаем кофе
    }

    public void pourIntoCup() {
        // наливаем в чашку
    }
}

class Americano extends Coffee {
}

class Cappuccino extends Coffee {
}

class CaffeLatte extends Coffee {
}

class Espresso extends Coffee {
}

class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = null;
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
        }
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
        System.out.println("There's your coffee");
        return coffee;
    }
}

