package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class SmallAngel extends Angel {
    public SmallAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "SmallAngel";
        super.sendAngelNotification(action, hero);
    }
}
