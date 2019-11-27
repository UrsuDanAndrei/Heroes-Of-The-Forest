package abilities.rogueAbilities;

import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;
import abilities.overtimeEffects.Paralyse;
import heroes.*;

public class Paralysis extends RogueAbility implements OvertimeAbility {
    private static final float ROGUE_MODIFIER = 0.9f;
    private static final float KNIGHT_MODIFIER = 0.8f;
    private static final float PYROMANCER_MODIFIER = 1.2f;
    private static final float WIZARD_MODIFIER = 1.25f;

    private static final int INITIAL_DAMAGE = 40;
    private static final int BONUS_DAMAGE_LEVEL_UP = 10;

    private Paralyse paralyse;

    public Paralysis() {
        damage = INITIAL_DAMAGE;
    }

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return paralyse;
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
        float terrainModifier = caster.getTerrainModifier();
        float finalDamage = damage * heroModifier * terrainModifier;

        int noRounds = caster.getTerrain().getTerrainAbilityModifier(this);

        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        hero.setOvertimeEffect(new Paralyse(noRounds, Math.round(finalDamage)));
        System.out.println("Paralysis: " + Math.round(finalDamage));
    }
}
