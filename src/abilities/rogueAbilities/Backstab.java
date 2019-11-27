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
    private float criticalHit;

    public Backstab() {
        damage = INITIAL_DAMAGE;
        criticalHit = 1.0f;
    }

    @Override
    public int getDamage() {
        System.out.println(damage + " " + caster.getTerrainModifier() + " " + criticalHit);
        // verifying if a critical hit is about to happen
        if (countHits % CRITICAL_HIT_PERIOD == 0) {
            criticalHit = caster.getTerrain().getTerrainAbilityModifier(this);
        }

        return Math.round(damage * caster.getTerrainModifier() * criticalHit);
    }

    @Override
    public void levelUp() {
        ++level;
        damage = INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * level;
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
        if (countHits % CRITICAL_HIT_PERIOD == 0) {
            criticalHit = caster.getTerrain().getTerrainAbilityModifier(this);
        } else {
            criticalHit = 1.0f;
        }
        ++countHits;

        float terrainModifier = caster.getTerrainModifier();
        float finalDamage = damage * heroModifier * terrainModifier * criticalHit;

        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        System.out.println("Backstab: " + Math.round(finalDamage));
    }
}
