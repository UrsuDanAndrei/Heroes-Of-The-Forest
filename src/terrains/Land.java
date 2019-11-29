package terrains;

import abilities.rogueAbilities.Backstab;
import abilities.rogueAbilities.Paralysis;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Land extends Terrain {
    public static final float PYROMANCER_MODIFIER = 1.0f;
    public static final float KNIGHT_MODIFIER = 1.15f;
    public static final float WIZARD_MODIFIER = 1.0f;
    public static final float ROGUE_MODIFIER = 1.0f;

    private static final int NO_ROUNDS_PARALYSIS = 3;
    private static final float BACKSTAB_BONUS_DAMAGE = 1.0f;

    @Override
    public float getTerrainModifier(final Pyromancer pyro) {
        return PYROMANCER_MODIFIER;
    }

    @Override
    public float getTerrainModifier(final Knight knight) {
        return KNIGHT_MODIFIER;
    }

    @Override
    public float getTerrainModifier(final Wizard wizard) {
        return WIZARD_MODIFIER;
    }

    @Override
    public float getTerrainModifier(final Rogue rogue) {
        return ROGUE_MODIFIER;
    }

    @Override
    public int getTerrainAbilityModifier(final Paralysis paralysis) {
        return NO_ROUNDS_PARALYSIS;
    }

    @Override
    public float getTerrainAbilityModifier(final Backstab backstab) {
        return BACKSTAB_BONUS_DAMAGE;
    }
}
