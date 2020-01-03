package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class LifeGiver extends Angel {
    public LifeGiver(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "LifeGiver";
        super.sendAngelNotification(action, hero);
    }
}
