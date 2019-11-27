package abilities.rogueAbilities;

import heroes.*;

public class Backstab extends RogueAbility {
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 0.9f;
    private static final float PYROMANCER_MODIFIER = 1.25f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private static final int INITIAL_DAMAGE = 200;
    private static final int BONUS_DAMAGE_LEVEL_UP = 20;

    private static final int CRITICAL_HIT_PERIOD = 3;

    private int countHits;

    @Override
    public void affectHero(Pyromancer pyro) {
        affectHero(pyro, PYROMANCER_MODIFIER);
    }

    @Override
    public void affectHero(Knight knight) {
        affectHero(knight, KNIGHT_MODIFIER);
    }

    @Override
    public void affectHero(Wizard wizard) {
        affectHero(wizard, WIZARD_MODIFIER);
    }

    @Override
    public void affectHero(Rogue rogue) {
        affectHero(rogue, ROGUE_MODIFIER);
    }

    private void affectHero(Hero hero, float heroModifier) {
        ++countHits;

        float finalDamage = damage * heroModifier;
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        float criticalHit = 1.0f;
        if (countHits % CRITICAL_HIT_PERIOD == 0) {
            criticalHit = caster.getTerrain().getTerrainAbilityModifier(this);
        }

        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier() * criticalHit;
    }
}
