package Tour;

import java.util.ArrayList;
import java.util.List;

public class PackageTour implements Tour {

    private String packageName;
    private List<Tour> tours = new ArrayList<Tour>();
    private int availableSeats;
    private int reservedSeats;

    public PackageTour(String packageName, List<Tour> tours) {
        this.packageName = packageName;
        this.tours = tours;
        this.availableSeats = calculateAvailableSeats();
        this.reservedSeats = 0;
    }

    public PackageTour(String packageName, Tour tour) {
        this(packageName);
        this.tours.add(tour);
        this.availableSeats = calculateAvailableSeats();
        this.reservedSeats = 0;
    }

    public PackageTour(String packageName) {
        this.packageName = packageName;
        this.reservedSeats = 0;
    }

    public void reservedSeats(int seat){
        this.reservedSeats += seat;
    }

    public void addTour(Tour tour){
        tours.add(tour);
    }

    private int calculateAvailableSeats(){
        int tmp = 0;
        boolean first = true;
        for (Tour t: tours){
            if (first){
                tmp = t.getAvailableSeats();
                first = false;
            }
            else if (t.getAvailableSeats() < tmp) tmp = t.getAvailableSeats();
        }
        return tmp;
    }

    @Override
    public String getName() {
        String tmp = this.packageName + "\n";
        for (Tour t: tours){
            tmp += " :" + t.getName() + "\n";
        }
        return tmp;
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Tour t: tours) total += t.getPrice();
        return total*0.9;
    }

    @Override
    public int getAvailableSeats() {
        return this.availableSeats - this.reservedSeats;
    }
}
