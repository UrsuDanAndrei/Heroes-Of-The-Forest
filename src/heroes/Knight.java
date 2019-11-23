package heroes;

import abilities.Ability;

public class Knight extends Hero {
    @Override
    public void getAffectedByAbility(Ability ability) {
        ability.affectHero(this);
    }
}
