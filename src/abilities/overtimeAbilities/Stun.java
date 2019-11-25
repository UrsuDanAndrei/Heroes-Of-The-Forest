package abilities.overtimeAbilities;

import abilities.knightAbilities.Slam;
import heroes.*;

public class Stun extends OvertimeEffect {

    public Stun(int noRounds) {
        super(noRounds);
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setStunned(true);
    }
}
