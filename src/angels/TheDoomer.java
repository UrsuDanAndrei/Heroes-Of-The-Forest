package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class TheDoomer extends Angel {
    public TheDoomer(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "TheDoomer";
        super.sendAngelNotification(action, hero);
    }
}
