package heroes;

import abilities.AbilitiesFactory;
import abilities.Ability;
import abilities.AbilityTypes;

import java.util.ArrayList;
import java.util.List;

public final class HeroesFactory {
    private static HeroesFactory instance = null;

    private HeroesFactory() {

    }

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }

        return instance;
    }

    public Hero createHero(HeroTypes type, int posMapX, int posMapY) {
        List<Ability> abilities = new ArrayList<>();
        AbilitiesFactory abilitiesFactory = AbilitiesFactory.getInstance();

        switch (type) {
            case PYROMANCER:
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.FIREBLAST));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.IGNITE));

                return new Pyromancer(posMapX, posMapY, abilities);
            case KNIGHT:
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.EXECUTE));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.SLAM));

                return new Knight(posMapX, posMapY, abilities);
            case WIZARD:
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.DRAIN));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.DEFLECT));

                return new Wizard(posMapX, posMapY, abilities);
            case ROGUE:
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.BACKSTAB));
                abilities.add(abilitiesFactory.creatAbility(AbilityTypes.PARALYSIS));

                return  new Rogue(posMapX, posMapY, abilities);
            default:
                return null;
        }
    }
}
