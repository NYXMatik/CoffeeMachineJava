package machine;
import java.util.Scanner;



public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;
    private Scanner scanner;

    // Constructor
    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 9;
        this.money = 550;
        this.scanner = new Scanner(System.in);
    }

    // Method to process user input
    public void processInput() {
        boolean p = true;
        while (p) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = scanner.next();

            switch (option) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillSupplies();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    p = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        // Assume the user inputs a valid option here
        // This part could be further refined to handle invalid input
        // For simplicity, I'm assuming valid input for now
        String option = scanner.next();
        switch (option) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break; // Do nothing, just go back to the main menu
            default:
                System.out.println("Invalid option");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffee >= coffeeNeeded && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffee -= coffeeNeeded;
            money += cost;
            cups--;
        } else {
            System.out.println("Sorry, not enough resources to make coffee.");
        }
    }

    private void fillSupplies() {
        // Assume the user inputs valid integers for filling supplies
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void printState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.processInput();
    }
}
