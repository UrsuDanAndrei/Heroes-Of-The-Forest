package heroes;

import abilities.AbilitiesFactory;
import abilities.Ability;
import abilities.AbilityTypes;

import java.util.ArrayList;
import java.util.List;

public final class HeroesFactory {
    private static HeroesFactory instance = null;

    // singleton pattern
    private HeroesFactory() {

    }

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }

        return instance;
    }

    public Hero createHero(final HeroTypes type, final int posMapX, final int posMapY,
                           final int id) {
        List<Ability> abilities = new ArrayList<>();
        AbilitiesFactory abilitiesFactory = AbilitiesFactory.getInstance();
        Hero hero;

        switch (type) {
            case PYROMANCER:
                // giving the pyromancer hero his specific abilities
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.FIREBLAST));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.IGNITE));
                hero =  new Pyromancer(posMapX, posMapY, abilities, id);

                // setting up the caster for abilities
                for (Ability ability : abilities) {
                    ability.setCaster(hero);
                }

                break;
            case KNIGHT:
                // giving the knight hero his specific abilities
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.EXECUTE));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.SLAM));
                hero = new Knight(posMapX, posMapY, abilities, id);

                // setting up the caster for abilities
                for (Ability ability : abilities) {
                    ability.setCaster(hero);
                }

                break;
            case WIZARD:
                // giving the wizard hero his specific abilities
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.DRAIN));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.DEFLECT));
                hero =  new Wizard(posMapX, posMapY, abilities, id);

                // setting up the caster for abilities
                for (Ability ability : abilities) {
                    ability.setCaster(hero);
                }

                break;
            case ROGUE:
                // giving the rogue hero his specific abilities
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.BACKSTAB));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.PARALYSIS));
                hero = new Rogue(posMapX, posMapY, abilities, id);

                // setting up the caster for abilities
                for (Ability ability : abilities) {
                    ability.setCaster(hero);
                }

                break;
            default:
                hero =  null;
        }

        return hero;
    }
}
