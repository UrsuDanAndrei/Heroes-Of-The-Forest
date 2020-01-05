package strategies;

import abilities.Ability;
import heroes.Hero;

import java.util.List;

public class RogueAttackStrategy implements Strategy {
    private static RogueAttackStrategy instance = null;

    private static final int HEALTH_FRACTION = -7;
    private static final float BONUS_MODIFIER = 0.4f;

    private RogueAttackStrategy() {

    }

    public static RogueAttackStrategy getInstance() {
        if (instance == null) {
            instance = new RogueAttackStrategy();
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
