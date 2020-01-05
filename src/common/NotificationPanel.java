package common;

import java.util.ArrayList;
import java.util.List;

// is responsible of keeping the track of the events
public final class NotificationPanel {
    private static NotificationPanel instance = null;

    private List<String> notifications;

    private NotificationPanel() {
        notifications = new ArrayList<>();
    }

    public static NotificationPanel getInstance() {
        if (instance == null) {
            instance = new NotificationPanel();
        }

        return instance;
    }

    public void addNotification(final String notification) {
        notifications.add(notification);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
