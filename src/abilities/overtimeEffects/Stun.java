package abilities.overtimeEffects;

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
