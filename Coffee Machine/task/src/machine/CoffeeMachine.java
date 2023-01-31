package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static Scanner scan;
    private static VirtualCoffeeMachine vcm;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        vcm = new VirtualCoffeeMachine(400, 540, 120, 9, 550);
        showMainMenu();

    }

    public static void showMainMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        switch (scan.next().toLowerCase()) {
            case "buy" -> buyCoffee();
            case "fill" -> fillMachine();
            case "take" -> takeMoney();
            case "remaining" -> printMachineState();
            case "exit" -> {
                return;
            }
        }
        showMainMenu();
    }

    public static void printMachineState() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                                
                """, vcm.getWater(), vcm.getMilk(), vcm.getBeans(), vcm.getDisposableCups(), vcm.getMoney());
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scan.next().toLowerCase();
        if (input.equals("back")) {
            return;
        }
        CoffeeType coffeeType = CoffeeType.getTypeById(Integer.parseInt(input));
        vcm.makeCoffee(coffeeType);
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scan.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int disposableCups = scan.nextInt();
        vcm.fillMachine(water, milk, beans, disposableCups);
    }

    public static void takeMoney() {
        int money = vcm.getMoney();
        vcm.setMoney(0);
        System.out.printf("I gave you $%d\n\n", money);
    }
}
