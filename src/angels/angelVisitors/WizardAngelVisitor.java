package angels.angelVisitors;

import abilities.Ability;
import angels.*;
import common.Constants;
import heroes.Hero;
import heroes.HeroActions;

import java.util.List;

public class WizardAngelVisitor implements AngelVisitor {
    private static WizardAngelVisitor instance = null;

    private static final float DAMAGE_ANGEL_MODIFIER = 0.4f;

    private static final int DARK_ANGEL_DAMAGE = 20;

    private static final float DRACULA_MODIFIER = -0.4f;
    private static final int DRACULA_DAMAGE = 20;

    private static final float GOOD_BOY_MODIFIER = 0.3f;
    private static final int GOOD_BOY_HEAL = 50;

    private static final float LEVEL_UP_ANGEL_MODIFIER = 0.25f;

    private static final int LIFE_GIVER_HEAL = 120;

    private static final float SMALL_ANGEL_MODIFIER = 0.1f;
    private static final int SMALL_ANGEL_HEAL = 25;

    private static final int SPAWNER_RESURRECT_HEALTH = 120;

    private static final int XP_ANGEL_BONUS_XP = 60;


    private WizardAngelVisitor() {

    }

    public static WizardAngelVisitor getInstance() {
        if (instance == null) {
            instance = new WizardAngelVisitor();
        }

        return instance;
    }

    @Override
    public void visit(DamageAngel damageAngel, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        damageAngel.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(DAMAGE_ANGEL_MODIFIER, hero);
    }

    @Override
    public void visit(DarkAngel darkAngel, Hero hero) {
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
    public void visit(Dracula dracula, Hero hero) {
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
    public void visit(GoodBoy goodBoy, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        goodBoy.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(GOOD_BOY_MODIFIER, hero);
        hero.setHealth(hero.getHealth() + GOOD_BOY_HEAL);
    }

    @Override
    public void visit(LevelUpAngel levelUpAngel, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        updateAllModifiers(LEVEL_UP_ANGEL_MODIFIER, hero);

        // adds xp to the hero and checks if he can level up
        hero.setXp(Constants.LEVEL1_XP_THRESHOLD
                + hero.getLevel() * Constants.ADDITIONAL_XP_TO_LEVEL_UP);
        hero.checkLevelUp();

        levelUpAngel.sendAngelNotification(AngelActions.HELP, hero);
    }

    @Override
    public void visit(LifeGiver lifeGiver, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        lifeGiver.sendAngelNotification(AngelActions.HELP, hero);

        hero.setHealth(hero.getHealth() + LIFE_GIVER_HEAL);
    }

    @Override
    public void visit(SmallAngel smallAngel, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        smallAngel.sendAngelNotification(AngelActions.HELP, hero);

        updateAllModifiers(SMALL_ANGEL_MODIFIER, hero);
        hero.setHealth(hero.getHealth() + SMALL_ANGEL_HEAL);
    }

    @Override
    public void visit(Spawner spawner, Hero hero) {
        if (!hero.isDead()) {
            return;
        }

        spawner.sendAngelNotification(AngelActions.HELP, hero);
        hero.setHealth(SPAWNER_RESURRECT_HEALTH);
        hero.sendHeroNotification(HeroActions.RESURRECTED_BY_ANGEL, null);
    }

    @Override
    public void visit(TheDoomer theDoomer, Hero hero) {
        if (hero.isDead()) {
            return;
        }

        theDoomer.sendAngelNotification(AngelActions.HIT, hero);
        hero.setHealth(0);
        hero.sendHeroNotification(HeroActions.KILLED_BY_ANGEL, null);
    }

    @Override
    public void visit(XPAngel xpAngel, Hero hero) {
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
