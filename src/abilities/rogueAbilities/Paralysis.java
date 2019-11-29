package abilities.rogueAbilities;

import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;
import abilities.overtimeEffects.Paralyse;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Paralysis extends RogueAbility implements OvertimeAbility {
    private static final float ROGUE_MODIFIER = 0.9f;
    private static final float KNIGHT_MODIFIER = 0.8f;
    private static final float PYROMANCER_MODIFIER = 1.2f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private static final int INITIAL_DAMAGE = 40;
    private static final int BONUS_DAMAGE_LEVEL_UP = 10;

    // overtime effect
    private Paralyse paralyse;
    private int noRoundsParalyse;

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return paralyse;
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

        // setting up a Paralyse effect on him
        hero.setOvertimeEffect(new Paralyse(noRoundsParalyse, Math.round(finalDamage)));
    }

    @Override
    public void updateAbility() {
        noRoundsParalyse = caster.getTerrain().getTerrainAbilityModifier(this);
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
    }
}
