package abilities.wizardAbilities;

import abilities.Ability;
import heroes.*;

import java.util.List;

public class Deflect extends WizardAbility {
    private static final float ROGUE_MODIFIER = 1.2f;
    private static final float KNIGHT_MODIFIER = 1.4f;
    private static final float PYROMANCER_MODIFIER = 1.3f;

    private static final float INITIAL_DEFLECT_PERCENT = 0.35f;
    private static final float BONUS_DEFLECT_PERCENT_LEVEL_UP = 0.02f;
    private static final float MAX_DEFLECT_PERCENT = 0.7f;

    private float deflectPercent;

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
        // this ability can not be applied to another wizard
    }

    @Override
    public void affectHero(Rogue rogue) {
        affectHero(rogue, ROGUE_MODIFIER);
    }

    private void affectHero(Hero hero, float heroModifier) {
        List<Ability> abilities = hero.getAbilities();
        float deflectedDamage = 0f;

        for (Ability ability : abilities) {
            deflectedDamage += ability.getDamage();
        }

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
