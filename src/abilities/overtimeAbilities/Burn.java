package abilities.overtimeAbilities;

import abilities.pyromancerAbilities.Ignite;
import heroes.*;

public class Burn extends OvertimeEffect {
    private int damage;

//    public Burn(Ignite ignite) {
//        super();
//    }

    public Burn(int damage, int noRounds) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setHealth(hero.getHealth() - damage);
    }
}
