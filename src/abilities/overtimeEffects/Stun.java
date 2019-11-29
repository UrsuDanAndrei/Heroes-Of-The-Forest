package abilities.overtimeEffects;

import heroes.Hero;

// Slam's overtime effect, stuns the hero for one round
public final class Stun extends OvertimeEffect {

    public Stun(final int noRounds) {
        super(noRounds);
    }

    @Override
    public void overtimeAffectHero(final Hero hero) {
        --noRounds;
        hero.setStunned(true);
    }
}
