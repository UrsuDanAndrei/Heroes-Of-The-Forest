package abilities.overtimeEffects;

import heroes.*;

public class Burn extends OvertimeEffect {
    private int damage;

    public Burn(int noRounds, int damage) {
        super(noRounds);
        this.damage = damage;
    }

    @Override
    public void overtimeAffectHero(Hero hero) {
        --noRounds;
        hero.setHealth(hero.getHealth() - damage);
    }
}
