import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalRecord {
    private String customerName;

    private List<Rental> rentals = new ArrayList<>();

    public RentalRecord(String customerName, ArrayList<Rental> rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    public boolean add(Rental rental) {
        return rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(rentals);
    }

    public String getCustomerName() {
        return customerName;
    }


}
