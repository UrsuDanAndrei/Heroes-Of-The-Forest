package heroes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import abilities.Ability;
import abilities.overtimeEffects.OvertimeEffect;
import angels.Angel;
import common.Constants;
import common.Map;
import strategies.Strategy;
import terrains.Terrain;

public abstract class Hero {
    protected int id;
    protected int health;
    protected int level;
    protected int xp;
    protected Strategy strategy;

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

    public final void addPropertyChangeListener(final PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    // notifies The Great Magician about an important action performed by this hero
    public void sendHeroNotification(final HeroActions action, final Hero hero) {
        switch (action) {
            case KILL:
                notification = "Player " + hero.toString() + " was killed by " + notification;
                break;
            case LEVEL_UP:
                notification = notification + " reached level " + level;
                break;
            case KILLED_BY_ANGEL:
                notification = "Player " + notification + " was killed by an angel";
                break;
            case RESURRECTED_BY_ANGEL:
                notification = "Player " + notification + " was brought to life by an angel";
                break;
            default:
                notification = null;
        }

        pcs.firePropertyChange("notification", "", this.notification);
    }

    public final void applyStrategy() {
        if (strategy != null) {
            strategy.applyStrategy(this);
        }
    }

    // based on the current status the hero chooses a strategy
    public abstract void chooseStrategy();

    public abstract void getAffectedByAbility(Ability ability);

    // if the hero suffers from an overtime effect he will get affected by it
    public abstract void getAffectedByOvertimeEffect();

    public abstract float getTerrainModifier();

    public abstract int getMaxHealth();

    // leveling up according to the xp and the threshold for each level
    public abstract void checkLevelUp();

    // increase hero's experience according to the enemy he has killed
    public final void bonusXpForKill(final Hero hero) {
        if (this.isDead()) {
            return;
        }

        xp += Math.max(0,
                Constants.BONUS_XP - (level - hero.getLevel()) * Constants.LEVEL_FACTOR_BONUS_XP);
    }

    // returns the terrain instance that is at hero's position on the map
    public final Terrain getTerrain() {
        return Map.getInstance().getTerrain(posMapX, posMapY);
    }

    // simulates angel's effect over the hero
    public abstract void getAffectedByAngel(Angel angel);

    public String toStringFullStatistics() {
        StringBuilder sb = new StringBuilder();

        if (isDead()) {
            sb.append(" dead");
        } else {
            sb.append(" ");
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

    // getters and setters
    public final int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public final int getLevel() {
        return level;
    }

    public final int getPosMapX() {
        return posMapX;
    }

    public final void setPosMapX(final int posMapX) {
        this.posMapX = posMapX;
    }

    public final int getPosMapY() {
        return posMapY;
    }

    public final void setPosMapY(final int posMapY) {
        this.posMapY = posMapY;
    }

    public final List<Ability> getAbilities() {
        return abilities;
    }

    public final void setAbilities(final List<Ability> abilities) {
        this.abilities = abilities;
    }

    public final boolean isStunned() {
        return stunned;
    }

    public final void setStunned(final boolean stunned) {
        this.stunned = stunned;
    }

    public final boolean isDead() {
        return health <= 0;
    }

    public final void setOvertimeEffect(final OvertimeEffect overtimeEffect) {
        this.overtimeEffect = overtimeEffect;
    }

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }
}
