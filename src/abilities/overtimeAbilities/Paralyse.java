package abilities.overtimeAbilities;

import heroes.Hero;

public class Paralyse extends OvertimeEffect {
    private int damage;

    public Paralyse(int damage, int noRounds) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setStunned(true);
        hero.setHealth(hero.getHealth() - damage);
    }
}
