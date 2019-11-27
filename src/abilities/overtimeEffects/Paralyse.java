package abilities.overtimeEffects;

import heroes.Hero;

public class Paralyse extends OvertimeEffect {
    private int damage;

    public Paralyse(int noRounds, int damage) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setStunned(true);
        hero.setHealth(hero.getHealth() - damage);
        System.out.println("Overtime Paralyse: " + damage);
    }
}
