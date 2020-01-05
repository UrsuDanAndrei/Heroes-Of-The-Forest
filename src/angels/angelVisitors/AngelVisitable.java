package angels.angelVisitors;

import heroes.Hero;

public interface AngelVisitable {
    void accept(AngelVisitor av, Hero hero);
}
