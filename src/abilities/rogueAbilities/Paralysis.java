package abilities.rogueAbilities;

import abilities.overtimeAbilities.OvertimeAbility;
import abilities.overtimeAbilities.OvertimeEffect;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Paralysis extends RogueAbility implements OvertimeAbility {
    public OvertimeEffect overtimeEffect;

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return overtimeEffect;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void affectHero(Pyromancer pyro) {
        // TODO
    }

    @Override
    public void affectHero(Knight knight) {
        // TODO
    }

    @Override
    public void affectHero(Wizard wizard) {
        // TODO
    }

    @Override
    public void affectHero(Rogue rogue) {
        // TODO
    }
}
