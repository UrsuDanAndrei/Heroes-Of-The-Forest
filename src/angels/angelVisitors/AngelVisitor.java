package angels.angelVisitors;

import angels.*;

public interface AngelVisitor {
    public void visit(DamageAngel damageAngel, );
    public void visit(DarkAngel darkAngel);
    public void visit(Dracula dracula);
    public void visit(GoodBoy goodBoy);
    public void visit(LevelUpAngel levelUpAngel);
    public void visit(LifeGiver lifeGiver);
    public void visit(SmallAngel smallAngel);
    public void visit(Spawner spawner);
    public void visit(TheDoomer theDoomer);
    public void visit(XPAngel xpAngel);
}
