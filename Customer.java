import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Event> reservationList;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.reservationList = new ArrayList<>();
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = "unknown@example.com";
        this.reservationList = new ArrayList<>();
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<Event> getReservationList() { return reservationList; }

    public void addReservation(Event event) {
        if (event.reserveSeat()) {
            reservationList.add(event);
            System.out.println("Reservation added: " + event.getName());
        } else {
            System.out.println("Reservation failed: " + event.getName());
        }
    }

    public void cancelReservation(Event event) {
        if (reservationList.contains(event)) {
            reservationList.remove(event);
            System.out.println("Reservation canceled: " + event.getName());
        } else {
            System.out.println("Event not found in reservation list.");
        }
    }

    public void displayReservations() {
        if (reservationList.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Event event : reservationList) {
                System.out.println(event);
            }
        }
    }
}
