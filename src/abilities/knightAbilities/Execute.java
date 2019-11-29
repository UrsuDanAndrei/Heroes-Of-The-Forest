package abilities.knightAbilities;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Execute extends KnightAbility {
    private static final float ROGUE_MODIFIER = 1.15f;
    private static final float KNIGHT_MODIFIER = 1.0f;
    private static final float PYROMANCER_MODIFIER = 1.1f;
    private static final float WIZARD_MODIFIER = 0.8f;

    private static final int INITIAL_DAMAGE = 200;
    private static final int BONUS_DAMAGE_LEVEL_UP = 30;

    private static final float INITIAL_HEALTH_LIMIT_PERCENT = 0.2f;
    private static final float BONUS_HEALTH_LIMIT_PERCENT_LEVEL_UP = 0.01f;
    private static final float MAX_HEALTH_LIMIT_PERCENT = 0.4f;

    private float healthLimitPercent;

    @Override
    public void affectHero(final Pyromancer pyro) {
        affectHero(pyro, PYROMANCER_MODIFIER);
    }

    @Override
    public void affectHero(final Knight knight) {
        affectHero(knight, KNIGHT_MODIFIER);
    }

    @Override
    public void affectHero(final Wizard wizard) {
        affectHero(wizard, WIZARD_MODIFIER);
    }

    @Override
    public void affectHero(final Rogue rogue) {
        affectHero(rogue, ROGUE_MODIFIER);
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
    }
}
