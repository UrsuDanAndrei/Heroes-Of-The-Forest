package abilities;

import heroes.Hero;

public abstract class Ability {
    public Hero caster;

    public abstract void affectHero(Pyromancer pyro);
    public abstract void affectHero(Knight knight);
    public abstract void affectHero(Wizard wizard);
    public abstract void affectHero(Rogue rogue);
}
