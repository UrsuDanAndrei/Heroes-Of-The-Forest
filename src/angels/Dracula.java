package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class Dracula extends Angel {
    public Dracula(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "Dracula";
        super.sendAngelNotification(action, hero);
    }
}
