package abilities.knightAbilities;

import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;
import abilities.overtimeEffects.Stun;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Slam extends KnightAbility implements OvertimeAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final int INITIAL_DAMAGE = 100;
    private static final int BONUS_DAMAGE_LEVEL_UP = 40;

    private static final int NO_ROUNDS_STUN = 1;

    // overtime effect
    private Stun stun;

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return stun;
    }

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
        // damaging the enemy hero
        float finalDamage = damage * heroModifier;
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));

        //  setting up a Stun on the enemy hero
        hero.setOvertimeEffect(new Stun(NO_ROUNDS_STUN));
    }

    @Override
    public void updateAbility() {
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
    }
}
