package angels.angelVisitors;

import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;

import heroes.Hero;

public interface AngelVisitor {
    void visit(DamageAngel damageAngel, Hero hero);
    void visit(DarkAngel darkAngel, Hero hero);
    void visit(Dracula dracula, Hero hero);
    void visit(GoodBoy goodBoy, Hero hero);
    void visit(LevelUpAngel levelUpAngel, Hero hero);
    void visit(LifeGiver lifeGiver, Hero hero);
    void visit(SmallAngel smallAngel, Hero hero);
    void visit(Spawner spawner, Hero hero);
    void visit(TheDoomer theDoomer, Hero hero);
    void visit(XPAngel xpAngel, Hero hero);
}
