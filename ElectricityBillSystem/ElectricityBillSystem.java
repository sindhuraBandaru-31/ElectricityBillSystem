import java.util.ArrayList;
import java.util.Scanner;

class Consumer {
    String name;
    int consumerId;
    int units;
    double billAmount;

    void calculateBill() {
        double amount;

        if (units <= 100) {
            amount = units * 1.5;
        } else if (units <= 200) {
            amount = (100 * 1.5) + (units - 100) * 2.5;
        } else {
            amount = (100 * 1.5) + (100 * 2.5) + (units - 200) * 4;
        }

        // Fixed charge
        billAmount = amount + 125;
    }

    void displayBill() {
        System.out.println("--------------------------------");
        System.out.println("Consumer Name   : " + name);
        System.out.println("Consumer ID     : " + consumerId);
        System.out.println("Units Consumed  : " + units);
        System.out.println("Total Bill (₹)  : " + billAmount);
        System.out.println("--------------------------------");
    }
}

public class ElectricityBillSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Consumer> consumers = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== ELECTRICITY BILL MENU =====");
            System.out.println("1. Add Consumer");
            System.out.println("2. Generate Bills");
            System.out.println("3. Display All Bills");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    Consumer c = new Consumer();

                    System.out.print("Enter Consumer Name: ");
                    c.name = sc.nextLine();

                    System.out.print("Enter Consumer ID: ");
                    c.consumerId = sc.nextInt();

                    System.out.print("Enter Units Consumed: ");
                    c.units = sc.nextInt();

                    consumers.add(c);
                    System.out.println("✅ Consumer added successfully!");
                    break;

                case 2:
                    if (consumers.isEmpty()) {
                        System.out.println("⚠️ No consumers available.");
                    } else {
                        for (Consumer con : consumers) {
                            con.calculateBill();
                        }
                        System.out.println("✅ Bills generated successfully!");
                    }
                    break;

                case 3:
                    if (consumers.isEmpty()) {
                        System.out.println("⚠️ No bill records to display.");
                    } else {
                        for (Consumer con : consumers) {
                            con.displayBill();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}