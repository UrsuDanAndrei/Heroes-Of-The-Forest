package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class Spawner extends Angel {
    public Spawner(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "Spawner";
        super.sendAngelNotification(action, hero);
    }
}