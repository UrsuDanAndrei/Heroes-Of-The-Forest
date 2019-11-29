package terrains;

import abilities.rogueAbilities.Backstab;
import abilities.rogueAbilities.Paralysis;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Terrain {
    public abstract float getTerrainModifier(Pyromancer pyro);
    public abstract float getTerrainModifier(Knight knight);
    public abstract float getTerrainModifier(Wizard wizard);
    public abstract float getTerrainModifier(Rogue rogue);

    public abstract int getTerrainAbilityModifier(Paralysis paralysis);
    public abstract float getTerrainAbilityModifier(Backstab backstab);
}
