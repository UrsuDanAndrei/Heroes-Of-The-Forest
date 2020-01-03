package angels;

import angels.angelVisitors.AngelVisitable;
import angels.angelVisitors.AngelVisitor;
import heroes.Hero;

import java.beans.PropertyChangeSupport;

public class XPAngel extends Angel implements AngelVisitable {
    public XPAngel(int posMapX, int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(AngelActions action, Hero hero) {
        notification = "XPAngel";
        super.sendAngelNotification(action, hero);
    }

    @Override
    public void accept(AngelVisitor av, Hero hero) {
        av.visit(this, hero);
    }
}
