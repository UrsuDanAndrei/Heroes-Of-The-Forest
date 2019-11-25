package abilities.knightAbilities;

import heroes.*;

public class Execute extends KnightAbility {
    private static final float ROGUE_MODIFIER = 1.15f;
    private static final float KNIGHT_MODIFIER = 1.0f;
    private static final float PYROMANCER_MODIFIER = 1.1f;
    private static final float WIZARD_MODIFIER = 0.8f;

    private static final int INITIAL_DAMAGE = 200;
    private static final int BONUS_DAMAGE_LEVEL_UP = 30;

    private static final float INITIAL_ENEMY_HEALTH_LIMIT = 0.2f;
    private static final float BONUS_ENEMY_HEALTH_LIMIT_LEVEL_UP = 0.01f;
    private static final float MAX_ENEMY_HEALTH_LIMIT = 0.4f;

    private float enemyHealthLimit;

    public Execute() {
        damage = INITIAL_DAMAGE;
        enemyHealthLimit = INITIAL_ENEMY_HEALTH_LIMIT;
    }

    @Override
    public void levelUp() {
        ++level;
        damage = INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * level;
        enemyHealthLimit = Math.min(MAX_ENEMY_HEALTH_LIMIT,
                INITIAL_ENEMY_HEALTH_LIMIT + BONUS_ENEMY_HEALTH_LIMIT_LEVEL_UP * level);
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
        if (hero.getHealth() < hero.getMaxHealth() * enemyHealthLimit) {
            hero.setHealth(0);
        } else {
            float terrainModifier = caster.getTerrainModifier();
            float finalDamage = damage * heroModifier * terrainModifier;

            hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        }
    }
}
