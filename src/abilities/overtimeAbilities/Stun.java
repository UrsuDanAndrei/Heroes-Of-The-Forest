package abilities.overtimeAbilities;

import heroes.*;

public class Stun extends OvertimeEffect {
    Stun(int noRounds) {
        super(noRounds);
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setStunned(true);
    }
}
