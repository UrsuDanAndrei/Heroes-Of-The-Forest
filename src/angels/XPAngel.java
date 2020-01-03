package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class XPAngel extends Angel {
    public XPAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "XPAngel";
        super.sendAngelNotification(action, hero);
    }
}
