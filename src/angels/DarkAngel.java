package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class DarkAngel extends Angel {
    public DarkAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "DarkAngel";
        super.sendAngelNotification(action, hero);
    }
}
