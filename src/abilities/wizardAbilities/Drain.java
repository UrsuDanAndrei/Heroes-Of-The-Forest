package abilities.wizardAbilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Drain extends WizardAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final float INITIAL_ENEMY_HEALTH_PERCENT = 0.2f;
    private static final float BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP = 0.05f;

    private float percent;

    public Drain() {
        damage = 0;
        percent = INITIAL_ENEMY_HEALTH_PERCENT;
    }

    @Override
    public void levelUp() {
        ++level;
        percent = INITIAL_ENEMY_HEALTH_PERCENT + BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP * level;
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
