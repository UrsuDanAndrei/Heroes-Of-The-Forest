package angels.angelVisitors;

import heroes.Hero;

public interface AngelVisitable {
    public void accept(AngelVisitor av, Hero hero);
}
