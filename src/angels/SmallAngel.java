package angels;

import angels.angelVisitors.AngelVisitable;
import angels.angelVisitors.AngelVisitor;
import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class SmallAngel extends Angel implements AngelVisitable {
    public SmallAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "SmallAngel";
        super.sendAngelNotification(action, hero);
    }

    @Override
    public void accept(AngelVisitor av, Hero hero) {
        av.visit(this, hero);
    }
}
