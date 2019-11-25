package abilities.pyromancerAbilities;

import heroes.*;

public class Fireblast extends  PyromancerAbility {
    public static final float ROGUE_MODIFIER = -0.2f;
    public static final float KNIGHT_MODIFIER = 0.2f;
    public static final float PYROMANCER_MODIFIER = -0.1f;
    public static final float WIZARD_MODIFIER = 0.05f;
    public static final int INITIAL_DAMAGE = 350;
    public static final int BONUS_DAMAGE_LEVEL = 50;

    Fireblast() {
        damage = INITIAL_DAMAGE;
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_LEVEL;
    }

    @Override
    public void affectHero(Pyromancer pyro) {
        affectHero(pyro, PYROMANCER_MODIFIER);
    }

    @Override
    public void affectHero(Knight knight) {
        affectHero(knight, PYROMANCER_MODIFIER);
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
    }
}
