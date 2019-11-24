package abilities.pyromancerAbilities;

import abilities.overtimeAbilities.OvertimeAbility;
import abilities.overtimeAbilities.OvertimeEffect;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends PyromancerAbility implements OvertimeAbility {
    private OvertimeEffect overtimeEffect;

    @Override
    public void levelUp() {

    }

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return overtimeEffect;
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
