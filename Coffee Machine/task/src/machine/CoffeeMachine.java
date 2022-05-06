package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int water;
    int beans;
    int milk;
    int cups;
    int money;

    public static void main(String[] args) {

        boolean exit = false;
        CoffeeMachine machine = new CoffeeMachine();

        Scanner scan = new Scanner(System.in);
        while (! exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String op = scan.next();
            if (op.equals("buy")) {
                machine.buy();
            } else if (op.equals("take")) {
                machine.take();
            } else if (op.equals("fill")) {
                machine.fill();
            } else if (op.equals("remaining")) {
                machine.printSupplies();
            } else if (op.equals("exit")) {
                exit = true;
                break;
            }
        }
    }

    static void stage5(){
        boolean exit = false;
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scan = new Scanner(System.in);
        while (! exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String op = scan.next();
            if (op.equals("buy")) {
                machine.buy();
            } else if (op.equals("take")) {
                machine.take();
            } else if (op.equals("fill")) {
                machine.fill();
            } else if (op.equals("remaining")) {
                machine.printSupplies();
            } else if (op.equals("exit")) {
                exit = true;
                break;
            }
        }
    }

    static void stage4(){
        CoffeeMachine machine = new CoffeeMachine();
        machine.printSupplies();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String op = scan.next();
        if (op.equals("buy")) {
            machine.buy();
        } else if (op.equals("take")) {
            machine.take();
        } else if (op.equals("fill")) {
            machine.fill();
        }
        machine.printSupplies();
    }
    void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.water += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.cups += scan.nextInt();
        scan.close();
    }

    void buy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String select = scan.next();

        switch (select){
            case "1":
                if (isPossibleEspresso()) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 250;
                this.beans -= 16;
                this.money += 4;
                this.cups -= 1;
                break;
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }

            case "2" :
                if (isPossibleLatte()) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 350;
                this.milk -= 75;
                this.beans -= 20;
                this.money += 7;
                this.cups -= 1;
                break;
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }

            case "3":
                if (isPossibleCappucino()) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 200;
                this.milk -= 100;
                this.beans -= 12;
                this.money += 6;
                this.cups -= 1;
                break;
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }

            case "back":
                break;
        }

//        if (drink == 1){
//            if (isPossibleEspresso()) {
//                System.out.println("I have enough resources, making you a coffee!");
//                this.water -= 250;
//                this.beans -= 16;
//                this.money += 4;
//                this.cups -= 1;
//            } else {
//                System.out.println("Sorry, not enough water!");
//            }
//        } else if (drink == 2) {
//            if (isPossibleLatte()) {
//                System.out.println("I have enough resources, making you a coffee!");
//                this.water -= 350;
//                this.milk -= 75;
//                this.beans -= 20;
//                this.money += 7;
//                this.cups -= 1;
//            } else {
//                System.out.println("Sorry, not enough water!");
//            }
//
//        } else if (drink == 3) {
//            if (isPossibleCappucino()) {
//                System.out.println("I have enough resources, making you a coffee!");
//                this.water -= 200;
//                this.milk -= 100;
//                this.beans -= 12;
//                this.money += 6;
//                this.cups -= 1;
//            } else {
//                System.out.println("Sorry, not enough water!");
//            }
//
//        }

    }

    void take(){
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public CoffeeMachine() {
        this.beans = 120;
        this.cups = 9;
        this.water = 400;
        this.milk = 540;
        this.money = 550;
    }

    @Override
    public String toString() {
        return "The Coffee Machine has: \n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money" ;
    }

    void printSupplies() {
        System.out.println(this.toString());
    }

    boolean isPossibleEspresso() {
        return (this.water - 250 >= 0 && this.beans - 16 >= 0);
    }

    boolean isPossibleLatte() {
        return (this.water - 350 >= 0 && this.beans - 20 >= 0 && this.milk - 75 >= 0);
    }

    boolean isPossibleCappucino() {
        return (this.water - 200 >= 0 && this.beans - 12 >= 0 && this.milk - 100 >= 0);
    }

    static void isPossible() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();
        scan.close();
        //numberPossiblePrint(cups, water, milk, beans);

        int possible = numberPossible(cups, water, milk, beans);
        if (possible < cups){
            System.out.println("No, I can make only " + possible + " cup(s) of coffee");
        } else if (possible > cups){
            System.out.println("Yes, I can make that amount of coffee (and even " + (possible - cups) + " more than that)");
        } else if (possible == cups){
            System.out.println("Yes, I can make that amount of coffee");
        }
    }

    static int numberPossible(int cups, int water, int milk, int beans) {
        int waterCups = water / 200;
        int milkCups = milk / 50;
        int beanCups = beans / 15;
        return Math.min(waterCups, Math.min(milkCups, beanCups));
    }

    static void numberPossiblePrint(int cups, int water, int milk, int beans) {
        int waterCups = water / 200;
        int milkCups = milk / 50;
        int beanCups = beans / 15;
       System.out.println(waterCups + "," + milkCups + "," + beanCups);
        System.out.println(water / 200 );
    }

    static void printNeeded(int cups) {
        System.out.println("For " + cups + " cups you will need:");
        System.out.println(200*cups + " ml of water");
        System.out.println(50*cups + " ml of milk");
        System.out.println(15*cups + " g of coffee beans");
    }
}
