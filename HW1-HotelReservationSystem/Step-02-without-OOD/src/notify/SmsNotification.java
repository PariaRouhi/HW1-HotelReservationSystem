package notify;

public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
