package Tour;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        TicketingMachine machine = new TicketingMachine();
        Scanner scan = new Scanner(System.in);
        boolean first = true;

        while (true) {
            System.out.println("Start Machine...");

            while (machine.getCurrentTour() == null) {
                if (first) {
                    System.out.println("----[ Choose Package Tour ]----");
                    System.out.print(machine.getName());
                    first = false;
                }
                try {
                    machine.setCurrentTour(scan.nextLine());
                } catch (NullPointerException e) {
                    e.getStackTrace();
                }

            }

            System.out.println("----[ Choose Package ]----" + "\n" + machine.getCurrentTour().getName());

            while (machine.getPayment() != 0){
                System.out.println("Total : " + machine.getPayment());
                System.out.println("----[ Insert money ]----");
                machine.pay(scan.nextDouble());
            }

            System.out.println("Change : " + machine.getChange());

            machine.setCurrentTour(null);
            first = true;

        }

    }

}
