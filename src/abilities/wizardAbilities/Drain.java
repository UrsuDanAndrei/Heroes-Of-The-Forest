package abilities.wizardAbilities;

import heroes.*;

public class Drain extends WizardAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final float INITIAL_HEALTH_PERCENT = 0.2f;
    private static final float BONUS_HEALTH_PERCENT_LEVEL_UP = 0.05f;

    private static final float LIMIT_PERCENT = 0.3f;

    private float healthPercent;

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
        float finalDamage = healthPercent * heroModifier
                * Math.min(LIMIT_PERCENT * hero.getMaxHealth(), hero.getHealth());
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
    }

    @Override
    public void updateAbility() {
        healthPercent = (INITIAL_HEALTH_PERCENT + BONUS_HEALTH_PERCENT_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
        damage = 0;
    }
}
