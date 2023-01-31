package machine;

public class VirtualCoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int disposableCups;
    private int money;

    public VirtualCoffeeMachine() {

    }

    public VirtualCoffeeMachine(int water, int milk, int beans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void makeCoffee(CoffeeType type) {
        if (checkIngredients(type)) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            return;
        }
        water -= type.getWater();
        milk -= type.getMilk();
        beans -= type.getBeans();
        disposableCups--;
        money += type.getCost();
    }

    private boolean checkIngredients(CoffeeType type) {
        if (water - type.getWater() < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk - type.getMilk() < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans - type.getBeans() < 0) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public void fillMachine(int water, int milk, int beans, int disposableCups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.disposableCups += disposableCups;
    }
}
