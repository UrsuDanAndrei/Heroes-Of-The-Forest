package strategies;

import abilities.Ability;
import heroes.Hero;

import java.util.List;

public class PyromancerAttackStrategy implements Strategy {
    private static final int HEALTH_FRACTION = -4;
    private static final float BONUS_MODIFIER = 0.7f;

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
