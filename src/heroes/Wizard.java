package heroes;

import abilities.Ability;

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
}
