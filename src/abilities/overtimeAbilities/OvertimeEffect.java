package abilities.overtimeAbilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class OvertimeEffect {
    public abstract void overtimeAffectHero(Pyromancer pyro);
    public abstract void overtimeAffectHero(Knight knight);
    public abstract void overtimeAffectHero(Wizard wizard);
    public abstract void overtimeAffectHero(Rogue rogue);
}
