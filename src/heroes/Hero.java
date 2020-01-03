package heroes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import abilities.Ability;
import abilities.overtimeEffects.OvertimeEffect;
import angels.Angel;
import common.Constants;
import common.Map;
import terrains.Terrain;

public abstract class Hero {
    protected int id;
    protected int health;
    protected int level;
    protected int xp;

    protected String notification;
    protected PropertyChangeSupport pcs;

    protected boolean stunned;

    protected int posMapX;
    protected int posMapY;

    protected List<Ability> abilities;
    protected OvertimeEffect overtimeEffect;

    public Hero() {

    }

    public Hero(final int posMapX, final int posMapY, final List<Ability> abilities, final int id) {
        this.id = id;
        this.posMapX = posMapX;
        this.posMapY = posMapY;
        this.abilities = abilities;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void sendHeroNotification(HeroActions action, Hero hero) {
        switch (action) {
            case KILL:
                notification = "Player " + hero.toString() + " was killed by " + notification;
                break;
            case LEVEL_UP:
                notification = notification + " reached level " + level;
                break;
            default:
                notification = null;
        }

        pcs.firePropertyChange("notification", "", this.notification);
    }

    public abstract void getAffectedByAbility(Ability ability);

    // if the hero suffers from an overtime effect he will get affected by it
    public abstract void getAffectedByOvertimeEffect();

    public abstract float getTerrainModifier();

    public abstract int getMaxHealth();

    // leveling up according to the xp and the threshold for each level
    public abstract void checkLevelUp();

    // increase hero's experience according to the enemy he has killed
    public void bonusXpForKill(final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        xp += Math.max(0,
                Constants.BONUS_XP - (level - hero.getLevel()) * Constants.LEVEL_FACTOR_BONUS_XP);
    }

    // returns the terrain instance that is at hero's position on the map
    public Terrain getTerrain() {
        return Map.getInstance().getTerrain(posMapX, posMapY);
    }

    // simulates angel's effect over the hero
    public abstract void getAffectedByAngel(Angel angel);

    // getters and setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public int getPosMapX() {
        return posMapX;
    }

    public void setPosMapX(final int posMapX) {
        this.posMapX = posMapX;
    }

    public int getPosMapY() {
        return posMapY;
    }

    public void setPosMapY(final int posMapY) {
        this.posMapY = posMapY;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(final List<Ability> abilities) {
        this.abilities = abilities;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(final boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void setOvertimeEffect(final OvertimeEffect overtimeEffect) {
        this.overtimeEffect = overtimeEffect;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
