package angels;

import angels.angelVisitors.AngelVisitable;
import angels.angelVisitors.AngelVisitor;
import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class DamageAngel extends Angel implements AngelVisitable {
    public DamageAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "DamageAngel";
        super.sendAngelNotification(action, hero);
    }

    @Override
    public void accept(AngelVisitor av, Hero hero) {
        av.visit(this, hero);
    }
}
