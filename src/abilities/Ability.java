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

    public void setCaster(final Hero caster) {
        this.caster = caster;
    }

    public int getDamage() {
        return Math.round(damage);
    }

    public float getRogueModifier() {
        return rogueModifier;
    }

    public void setRogueModifier(float rogueModifier) {
        this.rogueModifier = rogueModifier;
    }

    public float getKnightModifier() {
        return knightModifier;
    }

    public void setKnightModifier(float knightModifier) {
        this.knightModifier = knightModifier;
    }

    public float getPyromancerModifier() {
        return pyromancerModifier;
    }

    public void setPyromancerModifier(float pyromancerModifier) {
        this.pyromancerModifier = pyromancerModifier;
    }

    public float getWizardModifier() {
        return wizardModifier;
    }

    public void setWizardModifier(float wizardModifier) {
        this.wizardModifier = wizardModifier;
    }
}
