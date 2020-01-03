package heroes;

import abilities.Ability;
import angels.Angel;
import angels.angelVisitors.AngelVisitable;
import angels.angelVisitors.KnightAngelVisitor;
import angels.angelVisitors.PyromancerAngelVisitor;
import common.Constants;
import common.Map;

import java.beans.PropertyChangeSupport;
import java.util.List;

public final class Pyromancer extends Hero {
    private static final int INITIAL_HEALTH = 500;
    private static final int BONUS_HEALTH_LEVEL_UP = 50;

    public Pyromancer(final int posMapX, final int posMapY, final List<Ability> abilities, final int id) {
        super(posMapX, posMapY, abilities, id);
        health = INITIAL_HEALTH;
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void sendHeroNotification(HeroActions action, Hero hero) {
        notification = this.toString();
        super.sendHeroNotification(action, hero);
    }

    @Override
    public int getMaxHealth() {
        return INITIAL_HEALTH + BONUS_HEALTH_LEVEL_UP * level;
    }

    @Override
    public void checkLevelUp() {
        while (xp >= Constants.LEVEL1_XP_THRESHOLD + level * Constants.ADDITIONAL_XP_TO_LEVEL_UP) {
            ++level;

            if (!isDead()) {
                // restoring the pyromancer to his full health
                health = INITIAL_HEALTH + BONUS_HEALTH_LEVEL_UP * level;
            }

            // The Great Magician is notified about this leveling up
            this.sendHeroNotification(HeroActions.LEVEL_UP, null);
        }
    }

    @Override
    public void getAffectedByAbility(final Ability ability) {
        ability.affectHero(this);
    }

    @Override
    public float getTerrainModifier() {
        return Map.getInstance().getTerrain(posMapX, posMapY).getTerrainModifier(this);
    }

    @Override
    public void getAffectedByOvertimeEffect() {
        if (overtimeEffect != null) {
            if (overtimeEffect.getNoRounds() != 0) {
                overtimeEffect.overtimeAffectHero(this);
            } else {
                overtimeEffect = null;
            }
        }
    }

    @Override
    public void getAffectedByAngel(Angel angel) {
        PyromancerAngelVisitor pav = PyromancerAngelVisitor.getInstance();
        angel.accept(pav, this);
    }

    @Override
    public String toString() {
        return "Pyromancer " + id;
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.min(health, (INITIAL_HEALTH + level * BONUS_HEALTH_LEVEL_UP));
    }
}
