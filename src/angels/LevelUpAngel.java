package angels;

import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "LevelUpAngel";
        super.sendAngelNotification(action, hero);
    }
}
