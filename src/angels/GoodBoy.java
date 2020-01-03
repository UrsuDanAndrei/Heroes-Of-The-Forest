package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class GoodBoy extends Angel {
    public GoodBoy(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "GoodBoy";
        super.sendAngelNotification(action, hero);
    }
}
