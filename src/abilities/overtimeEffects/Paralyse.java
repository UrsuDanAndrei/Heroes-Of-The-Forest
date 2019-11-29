package abilities.overtimeEffects;

import heroes.Hero;

// Paralysis's overtime effect, damages and stuns the hero each round
public final class Paralyse extends OvertimeEffect {
    private int damage;

    public Paralyse(final int noRounds, final int damage) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(final Hero hero) {
        --noRounds;
        hero.setStunned(true);
        hero.setHealth(hero.getHealth() - damage);
    }


}
