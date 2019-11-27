package abilities.wizardAbilities;

import heroes.*;

public class Drain extends WizardAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final float INITIAL_ENEMY_HEALTH_PERCENT = 0.2f;
    private static final float BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP = 0.05f;

    private static final float MAX_HEALTH_PERCENT = 0.3f;

    private float enemyHealthPercent;

    public Drain() {
        damage = 0;
        enemyHealthPercent = INITIAL_ENEMY_HEALTH_PERCENT;
    }

    @Override
    public void levelUp() {
        ++level;
        enemyHealthPercent = INITIAL_ENEMY_HEALTH_PERCENT + BONUS_ENEMY_HEALTH_PERCENT_LEVEL_UP * level;
    }

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
        float terrainModifier = caster.getTerrainModifier();
        float finalDamage = enemyHealthPercent * heroModifier * terrainModifier
                * Math.min(MAX_HEALTH_PERCENT * hero.getMaxHealth(), hero.getHealth());

        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        System.out.println(Math.round(finalDamage));
    }
}
