package heroes;

import java.util.List;
import abilities.Ability;
import abilities.overtimeAbilities.OvertimeEffect;
import common.Constants;
import terrains.Terrain;

public abstract class Hero {
    protected int health;
    protected int level;
    protected int id;
    protected int xp;
    protected boolean stunned;
    protected boolean dead;

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

    public void bonusXpForKill(Hero hero2) {
        xp += Math.max(0,
                Constants.BONUS_XP - (level - hero2.getLevel()) * Constants.LEVEL_FACTOR_BONUS_XP);
        levelUp();
    }

    public void levelUp() {
        if (xp >= Constants.LEVEL1_XP_THRESHOLD + level * Constants.ADDITIONAL_XP_TO_NEXT_LEVEL) {
            ++level;
            for (Ability ability : abilities) {
                ability.levelUp();
            }
        }
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
