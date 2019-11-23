package heroes;

import abilities.Ability;

public class Pyromancer extends Hero {
    @Override
    public void getAffectedByAbility(Ability ability) {
        ability.affectHero(this);
    }
}
