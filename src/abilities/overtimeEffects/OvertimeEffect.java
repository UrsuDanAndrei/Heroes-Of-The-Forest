package abilities.overtimeEffects;

import heroes.*;

public abstract class OvertimeEffect {
    protected int noRounds;

    public OvertimeEffect(int noRounds) {
        this.noRounds = noRounds;
    }

    /*
     because all overtime effects are added to a hero at the moment of casting the ability
     there is no need to apply double dispatch between OvertimeEffect and Hero hierarchies (the
     principal is already applied between Ability and Hero)
     */
    public abstract void overtimeAffectHero(Hero hero);

    public int getNoRounds() {
        return noRounds;
    }

    public void setNoRounds(int noRounds) {
        this.noRounds = noRounds;
    }
}
