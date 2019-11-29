package abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Wizard;
import heroes.Rogue;

public abstract class Ability {
    protected Hero caster;
    protected float damage;

    public abstract void affectHero(Pyromancer pyro);
    public abstract void affectHero(Knight knight);
    public abstract void affectHero(Wizard wizard);
    public abstract void affectHero(Rogue rogue);

    public void setCaster(final Hero caster) {
        this.caster = caster;
    }

    public int getDamage() {
        return Math.round(damage);
    }

    public abstract void updateAbility();

}
