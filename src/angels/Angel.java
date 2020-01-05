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

    public Angel(final int posMapX, final int posMapY) {
        this.posMapX = posMapX;
        this.posMapY = posMapY;
    }

    public final void addPropertyChangeListener(final PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    // sends a notification to The Great Magician about an action that was performed by this angel
    public void sendAngelNotification(final AngelActions action, final Hero hero) {
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

    // getters and setters
    public final int getPosMapX() {
        return posMapX;
    }

    public final void setPosMapX(final int posMapX) {
        this.posMapX = posMapX;
    }

    public final int getPosMapY() {
        return posMapY;
    }

    public final void setPosMapY(final int posMapY) {
        this.posMapY = posMapY;
    }
}
