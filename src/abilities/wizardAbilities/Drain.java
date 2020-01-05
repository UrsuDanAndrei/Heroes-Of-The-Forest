package abilities.wizardAbilities;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Drain extends WizardAbility {
    private static final float INITIAL_ROGUE_MODIFIER = 0.8f;
    private static final float INITIAL_KNIGHT_MODIFIER = 1.2f;
    private static final float INITIAL_PYROMANCER_MODIFIER = 0.9f;
    private static final float INITIAL_WIZARD_MODIFIER = 1.05f;

    private static final float INITIAL_HEALTH_PERCENT = 0.2f;
    private static final float BONUS_HEALTH_PERCENT_LEVEL_UP = 0.05f;

    private static final float LIMIT_PERCENT = 0.3f;

    private float healthPercent;

    public Drain() {
        rogueModifier = INITIAL_ROGUE_MODIFIER;
        knightModifier = INITIAL_KNIGHT_MODIFIER;
        pyromancerModifier = INITIAL_PYROMANCER_MODIFIER;
        wizardModifier = INITIAL_WIZARD_MODIFIER;
    }

    @Override
    public void affectHero(final Pyromancer pyro) {
        affectHero(pyro, pyromancerModifier);
    }

    @Override
    public void affectHero(final Knight knight) {
        affectHero(knight, knightModifier);
    }

    @Override
    public void affectHero(final Wizard wizard) {
        affectHero(wizard, wizardModifier);
    }

    @Override
    public void affectHero(final Rogue rogue) {
        affectHero(rogue, rogueModifier);
    }

    private void affectHero(final Hero hero, final float heroModifier) {
        // damaging the enemy hero
        float finalDamage = healthPercent * heroModifier
                * Math.min(LIMIT_PERCENT * hero.getMaxHealth(), hero.getHealth());

        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        healthPercent = (INITIAL_HEALTH_PERCENT + BONUS_HEALTH_PERCENT_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
        damage = 0;
    }
}
