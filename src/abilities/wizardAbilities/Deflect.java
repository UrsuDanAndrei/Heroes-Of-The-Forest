package abilities.wizardAbilities;

import abilities.Ability;

import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

import java.util.List;

public final class Deflect extends WizardAbility {
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 1.4f;
    private static final float PYROMANCER_MODIFIER = 1.3f;

    private static final float INITIAL_DEFLECT_PERCENT = 0.35f;
    private static final float BONUS_DEFLECT_PERCENT_LEVEL_UP = 0.02f;
    private static final float MAX_DEFLECT_PERCENT = 0.7f;

    private float deflectPercent;

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
        // this ability can not be applied to another wizard
    }

    @Override
    public void affectHero(final Rogue rogue) {
        affectHero(rogue, ROGUE_MODIFIER);
    }

    private void affectHero(final Hero hero, final float heroModifier) {
        List<Ability> abilities = hero.getAbilities();
        float deflectedDamage = 0f;

        // calculating the damage received by the caster in the current fight
        for (Ability ability : abilities) {
            deflectedDamage += ability.getDamage();
        }

        // damaging the enemy hero with a portion of the damage taken by the caster
        float finalDamage = deflectedDamage * deflectPercent * heroModifier;
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        deflectPercent = Math.min(MAX_DEFLECT_PERCENT,
                INITIAL_DEFLECT_PERCENT + BONUS_DEFLECT_PERCENT_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
        damage = 0;
    }
}
