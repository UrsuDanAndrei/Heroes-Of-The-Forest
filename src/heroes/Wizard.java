package heroes;

import abilities.Ability;
import abilities.overtimeAbilities.OvertimeEffect;
import common.Map;
import terrains.Terrain;

import java.util.List;

public class Wizard extends Hero {
    private static final int INITIAL_HEALTH = 400;

    public Wizard(int posMapX, int posMapY, List<Ability> abilities) {
        super(posMapX, posMapY, abilities);
        health = INITIAL_HEALTH;
    }

    @Override
    public void getAffectedByAbility(Ability ability) {
        ability.affectHero(this);
    }

    @Override
    public float getTerrainModifier() {
        return Map.getInstance().getTerrain(posMapX, posMapY).getTerrainModifier(this);
    }

    @Override
    public void getAffectedByOvertimeEffect() {
        overtimeEffect.overtimeAffectHero(this);
    }
}
