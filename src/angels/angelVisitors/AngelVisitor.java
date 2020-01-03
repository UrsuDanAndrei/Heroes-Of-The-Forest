package angels.angelVisitors;

import angels.*;
import heroes.Hero;

public interface AngelVisitor {
    public void visit(DamageAngel damageAngel, Hero hero);
    public void visit(DarkAngel darkAngel, Hero hero);
    public void visit(Dracula dracula, Hero hero);
    public void visit(GoodBoy goodBoy, Hero hero);
    public void visit(LevelUpAngel levelUpAngel, Hero hero);
    public void visit(LifeGiver lifeGiver, Hero hero);
    public void visit(SmallAngel smallAngel, Hero hero);
    public void visit(Spawner spawner, Hero hero);
    public void visit(TheDoomer theDoomer, Hero hero);
    public void visit(XPAngel xpAngel, Hero hero);
}
