package notify;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}
