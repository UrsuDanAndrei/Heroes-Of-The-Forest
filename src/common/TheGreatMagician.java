package common;

import angels.AngelActions;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TheGreatMagician implements PropertyChangeListener {
    private static TheGreatMagician instance = null;

    private TheGreatMagician() {
        
    }

    public static TheGreatMagician getInstance() {
        if (instance == null) {
            instance = new TheGreatMagician();
        }

        return instance;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        // receives an notification about the most recent event and adds it to the NotificationPanel
        String notification =  (String) event.getNewValue();
        NotificationPanel.getInstance().addNotification(notification);
    }
}
