package terrains;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Volcanic extends Terrain {
    public final static float PYROMANCER_MODIFIER = 1.25f;
    public final static float KNIGHT_MODIFIER = 0f;
    public final static float WIZARD_MODIFIER = 0f;
    public final static float ROGUE_MODIFIER = 0f;

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
}
