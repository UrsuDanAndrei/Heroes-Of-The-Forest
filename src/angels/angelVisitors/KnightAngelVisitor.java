package angels.angelVisitors;

import abilities.Ability;
import angels.*;
import heroes.Hero;
import heroes.Knight;

import java.util.List;

public class KnightAngelVisitor implements AngelVisitor {
    public static KnightAngelVisitor instance = null;

    private static final float DAMAGE_ANGEL_MODIFIER = 0.15f;

    private static final int DARK_ANGEL_DAMAGE = 40;

    private static final float DRACULA_MODIFIER = -0.2f;
    private static final int DRACULA_DAMAGE = 60;

    private KnightAngelVisitor() {

    }

    public static KnightAngelVisitor getInstance() {
        if (instance == null) {
            instance = new KnightAngelVisitor();
        }

        return instance;
    }

    @Override
    public void visit(DamageAngel damageAngel, Hero hero) {
        updateAllModifiers(DAMAGE_ANGEL_MODIFIER, hero);
    }

    @Override
    public void visit(DarkAngel darkAngel, Hero hero) {
        hero.setHealth(hero.getHealth() - DARK_ANGEL_DAMAGE);
    }

    @Override
    public void visit(Dracula dracula, Hero hero) {
        updateAllModifiers(DRACULA_MODIFIER, hero);
        hero.setHealth(hero.getHealth() - DRACULA_DAMAGE);
    }

    @Override
    public void visit(GoodBoy goodBoy, Hero hero) {

    }

    @Override
    public void visit(LevelUpAngel levelUpAngel, Hero hero) {

    }

    @Override
    public void visit(LifeGiver lifeGiver, Hero hero) {

    }

    @Override
    public void visit(SmallAngel smallAngel, Hero hero) {

    }

    @Override
    public void visit(Spawner spawner, Hero hero) {

    }

    @Override
    public void visit(TheDoomer theDoomer, Hero hero) {

    }

    @Override
    public void visit(XPAngel xpAngel, Hero hero) {

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
