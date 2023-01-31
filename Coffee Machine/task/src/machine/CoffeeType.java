package machine;

public enum CoffeeType {

    ESPRESSO(1, 250, 0, 16, 4),
    LATTE(2, 350, 75, 20, 7),
    CAPPUCCINO(3, 200, 100, 12, 6);

    private final int id;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    CoffeeType(int id, int water, int milk, int beans, int cost) {
        this.id = id;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public int getId() {
        return id;
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

    public int getCost() {
        return cost;
    }

    public static CoffeeType getTypeById(int id) {
        for (CoffeeType type : values()) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }
}
