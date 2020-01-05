package angels;

import angels.angelVisitors.AngelVisitable;
import angels.angelVisitors.AngelVisitor;
import heroes.Hero;

import java.beans.PropertyChangeSupport;

public final class Spawner extends Angel implements AngelVisitable {
    public Spawner(final int posMapX, final int posMapY) {
        super(posMapX, posMapY);
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendAngelNotification(final AngelActions action, final Hero hero) {
        notification = "Spawner";
        super.sendAngelNotification(action, hero);
    }

    @Override
    public void accept(final AngelVisitor av, final Hero hero) {
        av.visit(this, hero);
    }
}
