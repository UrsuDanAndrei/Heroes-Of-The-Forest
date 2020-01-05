package angels.angelVisitors;

import abilities.Ability;

import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;
import angels.AngelActions;

import common.Constants;
import heroes.Hero;
import heroes.HeroActions;

import java.util.List;

public final class RogueAngelVisitor implements AngelVisitor {
    private static RogueAngelVisitor instance = null;

    private static final float DAMAGE_ANGEL_MODIFIER = 0.30f;

    private static final int DARK_ANGEL_DAMAGE = 10;

    private static final float DRACULA_MODIFIER = -0.1f;
    private static final int DRACULA_DAMAGE = 35;

    private static final float GOOD_BOY_MODIFIER = 0.4f;
    private static final int GOOD_BOY_HEAL = 40;

    private static final float LEVEL_UP_ANGEL_MODIFIER = 0.15f;

    private static final int LIFE_GIVER_HEAL = 90;

    private static final float SMALL_ANGEL_MODIFIER = 0.05f;
    private static final int SMALL_ANGEL_HEAL = 20;

    private static final int SPAWNER_RESURRECT_HEALTH = 180;

    private static final int XP_ANGEL_BONUS_XP = 40;


    private RogueAngelVisitor() {

    }

    public static RogueAngelVisitor getInstance() {
        if (instance == null) {
            instance = new RogueAngelVisitor();
        }

        return instance;
    }

    @Override
    public void visit(final DamageAngel damageAngel, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        damageAngel.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(DAMAGE_ANGEL_MODIFIER, hero);
    }

    @Override
    public void visit(final DarkAngel darkAngel, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        darkAngel.sendAngelNotification(AngelActions.HIT, hero);

        hero.setHealth(hero.getHealth() - DARK_ANGEL_DAMAGE);
        if (hero.isDead()) {
            hero.sendHeroNotification(HeroActions.KILLED_BY_ANGEL, null);
        }
    }

    @Override
    public void visit(final Dracula dracula, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        dracula.sendAngelNotification(AngelActions.HIT, hero);

        updateAllModifiers(DRACULA_MODIFIER, hero);
        hero.setHealth(hero.getHealth() - DRACULA_DAMAGE);
        if (hero.isDead()) {
            hero.sendHeroNotification(HeroActions.KILLED_BY_ANGEL, null);
        }
    }

    @Override
    public void visit(final GoodBoy goodBoy, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        goodBoy.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(GOOD_BOY_MODIFIER, hero);
        hero.setHealth(hero.getHealth() + GOOD_BOY_HEAL);
    }

    @Override
    public void visit(final LevelUpAngel levelUpAngel, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        levelUpAngel.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(LEVEL_UP_ANGEL_MODIFIER, hero);

        // adds xp to the hero and checks if he can level up
        hero.setXp(Constants.LEVEL1_XP_THRESHOLD
                + hero.getLevel() * Constants.ADDITIONAL_XP_TO_LEVEL_UP);
        hero.checkLevelUp();
    }

    @Override
    public void visit(final LifeGiver lifeGiver, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        lifeGiver.sendAngelNotification(AngelActions.HELP, hero);

        hero.setHealth(hero.getHealth() + LIFE_GIVER_HEAL);
    }

    @Override
    public void visit(final SmallAngel smallAngel, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        smallAngel.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(SMALL_ANGEL_MODIFIER, hero);
        hero.setHealth(hero.getHealth() + SMALL_ANGEL_HEAL);
    }

    @Override
    public void visit(final Spawner spawner, final Hero hero) {
        if (!hero.isDead()) {
            return;
        }

        spawner.sendAngelNotification(AngelActions.HELP, hero);
        hero.setHealth(SPAWNER_RESURRECT_HEALTH);
        hero.sendHeroNotification(HeroActions.RESURRECTED_BY_ANGEL, null);
    }

    @Override
    public void visit(final TheDoomer theDoomer, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        theDoomer.sendAngelNotification(AngelActions.HIT, hero);
        hero.setHealth(0);
        hero.sendHeroNotification(HeroActions.KILLED_BY_ANGEL, null);
    }

    @Override
    public void visit(final XPAngel xpAngel, final Hero hero) {
        if (hero.isDead()) {
            return;
        }

        xpAngel.sendAngelNotification(AngelActions.HELP, hero);

        hero.setXp(hero.getXp() + XP_ANGEL_BONUS_XP);
        hero.checkLevelUp();
    }

    // adds value to all hero modifiers, value can be < 0
    private void updateAllModifiers(final float value, final Hero hero) {
        List<Ability> abilities = hero.getAbilities();

        for (Ability ability : abilities) {
            ability.setKnightModifier(ability.getKnightModifier() + value);
            ability.setPyromancerModifier(ability.getPyromancerModifier() + value);
            ability.setWizardModifier(ability.getWizardModifier() + value);
            ability.setRogueModifier(ability.getRogueModifier() + value);
        }
    }
}
