package abilities.pyromancerAbilities;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class Fireblast extends PyromancerAbility {
    private static final float INITIAL_ROGUE_MODIFIER = 0.8f;
    private static final float INITIAL_KNIGHT_MODIFIER = 1.2f;
    private static final float INITIAL_PYROMANCER_MODIFIER = 0.9f;
    private static final float INITIAL_WIZARD_MODIFIER = 1.05f;

    private static final int INITIAL_DAMAGE = 350;
    private static final int BONUS_DAMAGE_LEVEL_UP = 50;

    public Fireblast() {
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
        float finalDamage = damage * heroModifier;

        // damaging the enemy hero
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();

        damage = Math.round(damage);
    }


}
