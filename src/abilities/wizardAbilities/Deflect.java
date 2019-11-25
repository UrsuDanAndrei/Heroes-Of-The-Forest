package abilities.wizardAbilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Deflect extends WizardAbility {
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 1.4f;
    private static final float PYROMANCER_MODIFIER = 1.3f;

    private static final float INITIAL_ENEMY_HEALTH_PERCENT = 0.35f;
    private static final float BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP = 0.02f;
    private static final float MAX_ENEMY_HEALTH_PERCENT = 0.7f;

    private float percent;

    public Deflect() {
        damage = 0;
        percent = INITIAL_ENEMY_HEALTH_PERCENT;
    }

    @Override
    public void levelUp() {
        ++level;
        percent = Math.max(
                INITIAL_ENEMY_HEALTH_PERCENT + BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP * level,
                MAX_ENEMY_HEALTH_PERCENT);
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
