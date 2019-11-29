package abilities.overtimeEffects;

import heroes.Hero;

// Ignite's overtime effect, damages the hero each round
public final class Burn extends OvertimeEffect {
    private int damage;

    public Burn(final int noRounds, final int damage) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(final Hero hero) {
        --noRounds;
        hero.setHealth(hero.getHealth() - damage);
    }
}
