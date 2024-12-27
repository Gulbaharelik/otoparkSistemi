
public class Admin implements Observer {
    public void update(String status) {
        System.out.println("Admin notified: Parking status - " + status);
    }
}