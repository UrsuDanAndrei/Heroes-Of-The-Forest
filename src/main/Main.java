package main;

import abilities.Ability;
import abilities.knightAbilities.Execute;
import common.Constants;
import common.Map;
import heroes.Hero;
import heroes.HeroTypes;
import heroes.Knight;
import heroes.Pyromancer;
import input.GameInput;
import input.GameInputReader;
import output.GameOutput;
import output.GameOutputWriter;
import terrains.Terrain;
import terrains.Volcanic;
import terrains.Woods;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameInputReader gameInputReader = new GameInputReader(args[0], args[1]);
        GameInput gameInput = gameInputReader.getGameInput();

        int noRounds = gameInput.getNoRounds();
        int noHeroes = gameInput.getNoHeroes();

        Map map = gameInput.getMap();
        List<Hero> heroes = gameInput.getHeroes();
        List<String> moves = gameInput.getMoves();

        for (int round = 0; round < noRounds; ++round) {
            System.out.println("-------------");
            for (int heroIndex = 0; heroIndex < noHeroes; ++heroIndex) {
                Hero hero = heroes.get(heroIndex);

                if (hero.isDead()) {
                    continue;
                }

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
                        System.out.println("Before fight " + round);
                        fight(hero1, hero2);
                        System.out.println("After fight");
                        System.out.println(hero1);
                        System.out.println(hero2);
                        System.out.println();
                    }
                }
            }
        }

        GameOutput gameOutput = new GameOutput(heroes);
        GameOutputWriter gameOutputWriter = new GameOutputWriter(args[0], args[1]);

        gameOutputWriter.write(gameOutput);
        gameOutputWriter.close();
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

        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println();

        for (Ability ability : abilities1) {
            hero2.getAffectedByAbility(ability);
        }

        for (Ability ability : abilities2) {
            hero1.getAffectedByAbility(ability);
        }

        if (hero1.isDead()) {
            hero2.bonusXpForKill(hero1);
            hero2.checkLevelUp();
        }

        if (hero2.isDead()) {
            hero1.bonusXpForKill(hero2);
            hero1.checkLevelUp();
        }
    }
}
