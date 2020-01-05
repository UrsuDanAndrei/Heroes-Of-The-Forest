package strategies;

import abilities.Ability;
import heroes.Hero;

import java.util.List;

public final class WizardDefenceStrategy implements Strategy {
    private static WizardDefenceStrategy instance;

    private static final int HEALTH_FRACTION = 5;
    private static final float BONUS_MODIFIER = -0.2f;

    private WizardDefenceStrategy() {

    }

    public static WizardDefenceStrategy getInstance() {
        if (instance == null) {
            instance = new WizardDefenceStrategy();
        }

        return instance;
    }

    @Override
    public void applyStrategy(final Hero hero) {
        hero.setHealth(hero.getHealth() + hero.getHealth() / HEALTH_FRACTION);

        List<Ability> abilities = hero.getAbilities();
        for (Ability ability : abilities) {
            ability.setPyromancerModifier(ability.getPyromancerModifier() + BONUS_MODIFIER);
            ability.setKnightModifier(ability.getKnightModifier() + BONUS_MODIFIER);
            ability.setRogueModifier(ability.getRogueModifier() + BONUS_MODIFIER);
            ability.setWizardModifier(ability.getWizardModifier() + BONUS_MODIFIER);
        }
    }
}
