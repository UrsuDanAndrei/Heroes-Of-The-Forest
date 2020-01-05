package abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Wizard;
import heroes.Rogue;

public abstract class Ability {
    protected Hero caster;
    protected float damage;

    protected float rogueModifier;
    protected float knightModifier;
    protected float pyromancerModifier;
    protected float wizardModifier;

    public abstract void affectHero(Pyromancer pyro);
    public abstract void affectHero(Knight knight);
    public abstract void affectHero(Wizard wizard);
    public abstract void affectHero(Rogue rogue);

    public abstract void updateAbility();

    public final void setCaster(final Hero caster) {
        this.caster = caster;
    }

    public final int getDamage() {
        return Math.round(damage);
    }

    public final float getRogueModifier() {
        return rogueModifier;
    }

    public final void setRogueModifier(final float rogueModifier) {
        this.rogueModifier = rogueModifier;
    }

    public final float getKnightModifier() {
        return knightModifier;
    }

    public final void setKnightModifier(final float knightModifier) {
        this.knightModifier = knightModifier;
    }

    public final float getPyromancerModifier() {
        return pyromancerModifier;
    }

    public final void setPyromancerModifier(final float pyromancerModifier) {
        this.pyromancerModifier = pyromancerModifier;
    }

    public final float getWizardModifier() {
        return wizardModifier;
    }

    public final void setWizardModifier(final float wizardModifier) {
        this.wizardModifier = wizardModifier;
    }
}
