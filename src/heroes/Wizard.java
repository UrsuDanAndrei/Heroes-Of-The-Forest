package heroes;

import abilities.Ability;

public class Wizard extends Hero {
    @Override
    public void getAffectedByAbility(Ability ability) {
        ability.affectHero(this);
    }
}
