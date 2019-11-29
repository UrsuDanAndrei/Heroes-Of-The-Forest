package abilities.rogueAbilities;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Backstab extends RogueAbility {
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 0.9f;
    private static final float PYROMANCER_MODIFIER = 1.25f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private static final int INITIAL_DAMAGE = 200;
    private static final int BONUS_DAMAGE_LEVEL_UP = 20;

    private static final int CRITICAL_HIT_PERIOD = 3;

    // counter for critical hits
    private int countHits;

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
        ++countHits;

        // damaging the enemy hero
        float finalDamage = damage * heroModifier;
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        float criticalHit = 1.0f;

        // checking if the next hit will be a critical one
        if (countHits % CRITICAL_HIT_PERIOD == 0) {
            criticalHit = caster.getTerrain().getTerrainAbilityModifier(this);
        }

        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier() * criticalHit;
    }
}
