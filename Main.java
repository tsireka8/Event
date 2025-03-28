public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        // Add events
        Event concert = new Event("Symphony Concert", 120.0);
        Event theater = new Event("Hamlet", 85.0);
        system.addEvent(concert);
        system.addEvent(theater);

        // Add customers
        Customer customer1 = new Customer("John", "Smith", "john@example.com");
        Customer customer2 = new Customer("Anna", "Johnson", "anna@example.com");
        system.addCustomer(customer1);
        system.addCustomer(customer2);

        // Make reservations
        system.makeReservation(customer1, concert);
        system.makeReservation(customer1, theater);
        system.makeReservation(customer2, concert);

        // Display reservations
        System.out.println("\nReservations for customer " + customer1.getFirstName() + " " + customer1.getLastName() + ":");
        customer1.displayReservations();

        // Modify event by reference
        Event concertRef = system.findEvent("Symphony Concert");
        System.out.println("\nChanging concert price from " + concertRef.getPrice() + " to 150.0");
        concertRef.setPrice(150.0);

        // Check if change is visible for all
        System.out.println("\nReservations for customer " + customer1.getFirstName() + ":");
        customer1.displayReservations();

        System.out.println("\nReservations for customer " + customer2.getFirstName() + ":");
        customer2.displayReservations();

        // Cancel reservation
        System.out.println("\nCustomer " + customer1.getFirstName() + " cancels theater reservation:");
        customer1.cancelReservation(theater);
        customer1.displayReservations();

        // Check available seats
        System.out.println("\nAvailable seats for concert: " + concert.getAvailableSeats() +
                " out of " + concert.getMaxNumberOfSeats());
    }
}
