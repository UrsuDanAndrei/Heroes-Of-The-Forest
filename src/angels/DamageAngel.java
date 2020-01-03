package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class DamageAngel extends Angel {
    public DamageAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "DamageAngel";
        super.sendAngelNotification(action, hero);
    }
}
