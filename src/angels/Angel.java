package angels;

import angels.angelVisitors.AngelVisitable;
import heroes.Hero;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Angel implements AngelVisitable {
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
        switch (action) {
            case HIT:
                notification += " hit " + hero.toString();
                break;
            case HELP:
                notification += " helped " + hero.toString();
                break;
            case SPAWN:
                notification = "Angel " + notification + " was spawned at "
                        + posMapX + " " + posMapY;
                break;
            default:
                notification = null;
        }

        pcs.firePropertyChange("notification", "", notification);
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
