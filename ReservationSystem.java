import java.util.ArrayList;

public class ReservationSystem {
    private ArrayList<Event> events;
    private ArrayList<Customer> customers;

    public ReservationSystem() {
        events = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addEvent(String name, double price) {
        Event event = new Event(name, price);
        events.add(event);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }

    public void makeReservation(Customer customer, Event event) {
        customer.addReservation(event);
    }

    public Event findEvent(String name) {
        for (Event e : events) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public Customer findCustomer(String lastName) {
        for (Customer c : customers) {
            if (c.getLastName().equalsIgnoreCase(lastName)) {
                return c;
            }
        }
        return null;
    }

    public void changeEventPrice(String name, double newPrice) {
        Event event = findEvent(name);
        if (event != null) {
            event.setPrice(newPrice);
            System.out.println("Price for '" + name + "' changed to " + newPrice);
        } else {
            System.out.println("Event not found: " + name);
        }
    }
}
