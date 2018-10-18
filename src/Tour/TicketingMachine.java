package Tour;

import java.util.ArrayList;
import java.util.List;

public class TicketingMachine implements Tour{

    ArrayList<Tour> allTours = new ArrayList<Tour>();
    private Tour currentTour;
    private double payment;
    private double change;

    public TicketingMachine() {
        Tour floatingMarket = new SingleTour("Khlong Lad Mayom Floating Market", 600, 10);
        Tour temple = new SingleTour("Wat Phra Kaew", 800, 12);
        allTours.add(floatingMarket);
        allTours.add(temple);

        List<Tour> tours = new ArrayList<Tour>();
        tours.add(floatingMarket);
        tours.add(temple);

        Tour twoSingle = new PackageTour("Market & Temple", tours);
        allTours.add(twoSingle);
    }

    public void setCurrentTour(String name) {
        if (name == null) this.currentTour = null;
        else {
            String[] tmp;
            for (Tour t : allTours) {
                tmp = t.getName().split("\\n");
                if (name.equals(tmp[0])) {
                    this.currentTour = t;
                    break;
                }
            }
            this.payment = this.currentTour.getPrice();
            this.change = 0;
        }
    }

    public void pay(double money){
        this.payment -= money;
        if (this.payment < 0){
            this.change -= this.payment;
            this.payment = 0;
        }
    }

    public Tour getCurrentTour() {
        return currentTour;
    }

    public double getPayment() {
        return payment;
    }

    public double getChange() {
        return change;
    }

    @Override
    public String getName() {
        String tmp = "";
        for (Tour t: allTours) tmp += t.getName() + "\n";
        return tmp;
    }

    @Override
    public double getPrice() {
        return this.currentTour.getPrice();
    }

    @Override
    public int getAvailableSeats() {
        return this.currentTour.getAvailableSeats();
    }
}
