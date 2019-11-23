package abilities;

import abilities.knightAbilities.Execute;
import abilities.knightAbilities.Slam;
import abilities.pyromancerAbilities.Fireblast;
import abilities.pyromancerAbilities.Ignite;
import abilities.rogueAbilities.Backstab;
import abilities.rogueAbilities.Paralysis;
import abilities.wizardAbilities.Deflect;
import abilities.wizardAbilities.Drain;

public final class AbilitiesFactory {
    private static AbilitiesFactory instance = null;

    private AbilitiesFactory() {

    }

    public static AbilitiesFactory getInstance() {
        if (instance == null) {
            instance = new AbilitiesFactory();
        }
        return instance;
    }

    public Ability creatAbility(AbilityTypes type) {
        switch (type) {
            case FIREBLAST:
                return new Fireblast();
            case IGNITE:
                return  new Ignite();
            case EXECUTE:
                return new Execute();
            case SLAM:
                return new Slam();
            case DRAIN:
                return new Drain();
            case DEFLECT:
                return new Deflect();
            case BACKSTAB:
                return new Backstab();
            case PARALYSIS:
                return new Paralysis();
            default:
                return null;
        }
    }
}
