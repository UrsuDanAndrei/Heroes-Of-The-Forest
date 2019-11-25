package terrains;

import abilities.rogueAbilities.Backstab;
import abilities.rogueAbilities.Paralysis;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Land extends Terrain {
    public final static float PYROMANCER_MODIFIER = 1.0f;
    public final static float KNIGHT_MODIFIER = 1.15f;
    public final static float WIZARD_MODIFIER = 1.0f;
    public final static float ROGUE_MODIFIER = 1.0f;

    private final static int NO_ROUNDS_PARALYSIS = 3;
    private final static float BACKSTAB_BONUS_DAMAGE = 1.0f;

    @Override
    public float getTerrainModifier(Pyromancer pyro) {
        return PYROMANCER_MODIFIER;
    }

    @Override
    public float getTerrainModifier(Knight knight) {
        return KNIGHT_MODIFIER;
    }

    @Override
    public float getTerrainModifier(Wizard wizard) {
        return WIZARD_MODIFIER;
    }

    @Override
    public float getTerrainModifier(Rogue rogue) {
        return ROGUE_MODIFIER;
    }

    @Override
    public int getTerrainAbilityModifier(Paralysis paralysis) {
        return NO_ROUNDS_PARALYSIS;
    }

    @Override
    public float getTerrainAbilityModifier(Backstab backstab) {
        return BACKSTAB_BONUS_DAMAGE;
    }
}
