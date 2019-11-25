package main;

import abilities.Ability;
import abilities.knightAbilities.Execute;
import common.Constants;
import common.Map;
import heroes.Hero;
import heroes.HeroTypes;
import heroes.Knight;
import heroes.Pyromancer;
import input.GameInputReader;
import terrains.Terrain;
import terrains.Volcanic;
import terrains.Woods;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameInputReader gameInputReader = new GameInputReader(args[0], args[1]);
        gameInputReader.read();

        int noRounds = gameInputReader.getNoRounds();
        int noHeroes = gameInputReader.getNoHeroes();

        Map map = gameInputReader.getMap();
        List<Hero> heroes = gameInputReader.getHeroes();
        List<String> moves = gameInputReader.getMoves();

        for (int round = 0; round < noRounds; ++round) {
            for (int heroIndex = 0; heroIndex < noHeroes; ++heroIndex) {
                Hero hero = heroes.get(heroIndex);
                hero.getAffectedByOvertimeEffect();

                if (hero.isStunned()) {
                    hero.setStunned(false);
                } else {
                    map.moveHero(hero, moves.get(round).charAt(heroIndex));
                }
            }

            for (int i = 0; i < noHeroes; ++i) {
                for (int j = i + 1; j < noHeroes; ++j) {
                    Hero hero1 = heroes.get(i);
                    Hero hero2 = heroes.get(j);

                    if (samePosition(hero1, hero2) && bothAlive(hero1, hero2)) {
                        fight(hero1, hero2);
                    }
                }
            }
        }
    }

    private static boolean samePosition(Hero hero1, Hero hero2) {
        return hero1.getPosMapX() == hero2.getPosMapX() && hero1.getPosMapY() == hero2.getPosMapY();
    }

    private static boolean bothAlive(Hero hero1, Hero hero2) {
        return !(hero1.isDead() || hero2.isDead());
    }

    private static void fight(Hero hero1, Hero hero2) {
        List<Ability> abilities1 = hero1.getAbilities();
        List<Ability> abilities2 = hero2.getAbilities();

        for (Ability ability : abilities1) {
            hero2.getAffectedByAbility(ability);

            if (hero2.isDead()) {
                hero1.bonusXpForKill(hero2);
            }
        }

        for (Ability ability : abilities2) {
            hero1.getAffectedByAbility(ability);

            if (hero1.isDead()) {
                hero1.bonusXpForKill(hero2);
            }
        }
    }
}
