package heroes;

import java.util.List;
import abilities.Ability;
import abilities.overtimeAbilities.OvertimeEffect;

public abstract class Hero {
    protected int health;
    protected int damage;
    protected int level;

    protected int posMapX;
    protected int posMapY;

    protected List<Ability> abilities;
    protected OvertimeEffect overtimeEffect;

    public Hero() {

    }

    public Hero(int posMapX, int posMapY, List<Ability> abilities) {
        this.posMapX = posMapX;
        this.posMapY = posMapY;
        this.abilities = abilities;
    }

    public abstract void getAffectedByAbility(Ability ability);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosMapX() {
        return posMapX;
    }

    public void setPosMapX(int posMapX) {
        this.posMapX = posMapX;
    }

    public int getPosMapY() {
        return posMapY;
    }

    public void setPosMapY(int posMapY) {
        this.posMapY = posMapY;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public OvertimeEffect getOvertimeEffect() {
        return overtimeEffect;
    }

    public void setOvertimeEffect(OvertimeEffect overtimeEffect) {
        this.overtimeEffect = overtimeEffect;
    }
}
