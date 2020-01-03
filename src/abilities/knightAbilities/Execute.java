package abilities.knightAbilities;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Execute extends KnightAbility {
    private static final float INITIAL_ROGUE_MODIFIER = 1.15f;
    private static final float INITIAL_KNIGHT_MODIFIER = 1.0f;
    private static final float INITIAL_PYROMANCER_MODIFIER = 1.1f;
    private static final float INITIAL_WIZARD_MODIFIER = 0.8f;

    private static final int INITIAL_DAMAGE = 200;
    private static final int BONUS_DAMAGE_LEVEL_UP = 30;

    private static final float INITIAL_HEALTH_LIMIT_PERCENT = 0.2f;
    private static final float BONUS_HEALTH_LIMIT_PERCENT_LEVEL_UP = 0.01f;
    private static final float MAX_HEALTH_LIMIT_PERCENT = 0.4f;

    private float healthLimitPercent;

    public Execute() {
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
        affectHero(knight, INITIAL_KNIGHT_MODIFIER);
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
        // if the hero is under the health limit the ability will kill him
        if (hero.getHealth() < hero.getMaxHealth() * healthLimitPercent) {
            hero.setHealth(0);
        } else {
            float finalDamage = damage * heroModifier;
            hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        }
    }

    @Override
    public void updateAbility() {
        healthLimitPercent = Math.min(MAX_HEALTH_LIMIT_PERCENT, INITIAL_HEALTH_LIMIT_PERCENT
                + BONUS_HEALTH_LIMIT_PERCENT_LEVEL_UP * caster.getLevel());
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();

        damage = Math.round(damage);
    }
}
