package abilities.knightAbilities;

import abilities.OvertimeAbility;
import abilities.overtimeEffects.OvertimeEffect;
import abilities.overtimeEffects.Stun;
import heroes.*;

public class Slam extends KnightAbility implements OvertimeAbility {
    private static final float ROGUE_MODIFIER = 0.8f;
    private static final float KNIGHT_MODIFIER = 1.2f;
    private static final float PYROMANCER_MODIFIER = 0.9f;
    private static final float WIZARD_MODIFIER = 1.05f;

    private static final int INITIAL_DAMAGE = 100;
    private static final int BONUS_DAMAGE_LEVEL_UP = 40;

    private static final int NO_ROUNDS_STUN = 1;

    private OvertimeEffect overtimeEffect;

    @Override
    public OvertimeEffect getOvertimeEffect() {
        return overtimeEffect;
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
        float finalDamage = damage * heroModifier;
        hero.setHealth(hero.getHealth() - Math.round(finalDamage));
        hero.setOvertimeEffect(new Stun(NO_ROUNDS_STUN));
    }

    @Override
    public void updateAbility() {
        damage = (INITIAL_DAMAGE + BONUS_DAMAGE_LEVEL_UP * caster.getLevel())
                * caster.getTerrainModifier();
    }
}
