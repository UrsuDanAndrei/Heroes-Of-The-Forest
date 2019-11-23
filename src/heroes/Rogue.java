package heroes;

import abilities.Ability;

public class Rogue extends Hero {
    @Override
    public void getAffectedByAbility(Ability ability) {
        ability.affectHero(this);
    }
}
