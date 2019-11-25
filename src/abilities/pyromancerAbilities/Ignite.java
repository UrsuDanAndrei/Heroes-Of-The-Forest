package abilities.pyromancerAbilities;

import abilities.overtimeEffects.Burn;
import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;
import heroes.*;

public class Ignite extends PyromancerAbility implements OvertimeAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final int INITIAL_DAMAGE = 150;
    private static final int BONUS_DAMAGE_LEVEL_UP = 20;

    private static final int INITIAL_BURN_DAMAGE = 50;
    private static final int BONUS_BURN_DAMAGE_LEVEL_UP = 30;
    private static final int NO_ROUNDS_BURN = 2;

    private Burn burn;

    public Ignite() {
        damage = INITIAL_DAMAGE;
    }

    @Override
    public void levelUp() {
        ++level;
        damage = INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * level;
    }

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return burn;
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
        float finalDamage = damage * heroModifier * terrainModifier;

        hero.setHealth(hero.getHealth() - Math.round(finalDamage));

        float burnDamage = INITIAL_BURN_DAMAGE + BONUS_BURN_DAMAGE_LEVEL_UP * level;
        float finalBurnDamage = burnDamage * heroModifier * terrainModifier;

        hero.setOvertimeEffect(new Burn(NO_ROUNDS_BURN, Math.round(finalBurnDamage)));
    }
}
