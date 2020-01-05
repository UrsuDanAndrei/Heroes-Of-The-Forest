package heroes;

import abilities.Ability;
import angels.Angel;
import angels.angelVisitors.KnightAngelVisitor;
import common.Constants;
import common.Map;
import strategies.PyromancerAttackStrategy;
import strategies.PyromancerDefenceStrategy;

import java.beans.PropertyChangeSupport;
import java.util.List;

public final class Knight extends Hero {
    private static final int INITIAL_HEALTH = 900;
    private static final int BONUS_HEALTH_LEVEL_UP = 80;

    private static final int HEALTH_FACTOR_DOWN_STRATEGY = 3;
    private static final int HEALTH_FACTOR_UP_STRATEGY = 2;

    public Knight(final int posMapX, final int posMapY, final List<Ability> abilities, final int id) {
        super(posMapX, posMapY, abilities, id);
        health = INITIAL_HEALTH;
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void chooseStrategy() {
        strategy = null;
        int maxHealthLevel = (INITIAL_HEALTH + level * BONUS_HEALTH_LEVEL_UP);

        if (maxHealthLevel / HEALTH_FACTOR_DOWN_STRATEGY < health
                && health < maxHealthLevel / HEALTH_FACTOR_UP_STRATEGY) {
            strategy = new PyromancerAttackStrategy();
        }

        if (health < maxHealthLevel / HEALTH_FACTOR_DOWN_STRATEGY) {
            strategy = new PyromancerDefenceStrategy();
        }
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
                // restoring the knight to his full health
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
        KnightAngelVisitor kav = KnightAngelVisitor.getInstance();
        angel.accept(kav, this);
    }

    @Override
    public String toString() {
        return "Knight " + id;
    }

    @Override
    public String toStringFullStatistics() {
        return "K" + super.toStringFullStatistics();
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.min(health, (INITIAL_HEALTH + level * BONUS_HEALTH_LEVEL_UP));
    }
}
