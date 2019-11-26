package heroes;

import java.util.List;
import abilities.Ability;
import abilities.overtimeEffects.OvertimeEffect;
import common.Constants;
import common.Map;
import terrains.Terrain;

public abstract class Hero {
    protected int health;
    protected int level;
    protected int id;
    protected int xp;
    protected boolean stunned;

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

    public abstract float getTerrainModifier();

    public abstract void getAffectedByAbility(Ability ability);

    public abstract void getAffectedByOvertimeEffect();

    public abstract int getMaxHealth();

    public abstract void checkLevelUp();

    public void bonusXpForKill(Hero hero) {
        xp += Math.max(0,
                Constants.BONUS_XP - (level - hero.getLevel()) * Constants.LEVEL_FACTOR_BONUS_XP);
    }

    public Terrain getTerrain() {
        return Map.getInstance().getTerrain(posMapX, posMapY);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isDead()) {
            sb.append("dead");
        } else {
            sb.append(level);
            sb.append(" ");
            sb.append(xp);
            sb.append(" ");
            sb.append(health);
            sb.append(" ");
            sb.append(posMapX);
            sb.append(" ");
            sb.append(posMapY);
        }

        return sb.toString();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void setOvertimeEffect(OvertimeEffect overtimeEffect) {
        this.overtimeEffect = overtimeEffect;
    }
}
