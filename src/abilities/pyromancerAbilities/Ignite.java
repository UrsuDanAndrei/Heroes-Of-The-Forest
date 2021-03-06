package abilities.pyromancerAbilities;

import abilities.overtimeEffects.Burn;
import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Ignite extends PyromancerAbility implements OvertimeAbility {
    private static final float INITIAL_ROGUE_MODIFIER = 0.8f;
    private static final float INITIAL_KNIGHT_MODIFIER = 1.2f;
    private static final float INITIAL_PYROMANCER_MODIFIER = 0.9f;
    private static final float INITIAL_WIZARD_MODIFIER = 1.05f;

    private static final int INITIAL_DAMAGE = 150;
    private static final int BONUS_DAMAGE_LEVEL_UP = 20;

    private static final int INITIAL_BURN_DAMAGE = 50;
    private static final int BONUS_BURN_DAMAGE_LEVEL_UP = 30;
    private static final int NO_ROUNDS_BURN = 2;

    // overtime effect
    private Burn burn;
    private float burnDamage;

    public Ignite() {
        rogueModifier = INITIAL_ROGUE_MODIFIER;
        knightModifier = INITIAL_KNIGHT_MODIFIER;
        pyromancerModifier = INITIAL_PYROMANCER_MODIFIER;
        wizardModifier = INITIAL_WIZARD_MODIFIER;
    }

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return burn;
    }

    @Override
    public void affectHero(final Pyromancer pyro) {
        affectHero(pyro, rogueModifier);
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
        float finalDamage = damage * heroModifier;
        // damaging the enemy hero
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        float finalBurnDamage = burnDamage * heroModifier;

        // setting up a Burn on the enemy hero
        hero.setOvertimeEffect(new Burn(NO_ROUNDS_BURN, Math.round(finalBurnDamage)));
    }

    @Override
    public void updateAbility() {
        burnDamage = (INITIAL_BURN_DAMAGE + BONUS_BURN_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();

        burnDamage = Math.round(burnDamage);
        damage = Math.round(damage);
    }
}
