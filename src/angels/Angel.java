package angels;

import heroes.Hero;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Angel {
    protected int posMapX;
    protected int posMapY;

    protected String notification;
    protected PropertyChangeSupport pcs;

    public Angel(int posMapX, int posMapY) {
        this.posMapX = posMapX;
        this.posMapY = posMapY;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void sendAngelNotification(AngelActions action, Hero hero) {
        switch ()
        pcs.firePropertyChange("notification", this.notification, notification);
    }

    public int getPosMapX() {
        return posMapX;
    }

    public void setPosMapX(int posMapX) {
        this.posMapX = posMapX;
    }

    public int getPosMapY() {
        return posMapY;
    }

    public void setPosMapY(int posMapY) {
        this.posMapY = posMapY;
    }
}
