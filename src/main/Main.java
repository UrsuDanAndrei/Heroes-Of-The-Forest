package main;

import abilities.Ability;

import common.Map;

import heroes.Hero;

import input.GameInput;
import input.GameInputReader;

import output.GameOutput;
import output.GameOutputWriter;

import java.util.List;

public final class Main {
    private Main() {

    }

    public static void main(final String[] args) {
        // reading data from the file given as argument and storing it in gameInput
        GameInputReader gameInputReader = new GameInputReader(args[0], args[1]);
        GameInput gameInput = gameInputReader.getGameInput();

        int noRounds = gameInput.getNoRounds();
        int noHeroes = gameInput.getNoHeroes();

        Map map = gameInput.getMap();
        List<Hero> heroes = gameInput.getHeroes();
        List<String> moves = gameInput.getMoves();

        // simulating the fame flow
        for (int round = 0; round < noRounds; ++round) {
            // each hero moves (if he can) as dictated by the array moves
            for (int heroIndex = 0; heroIndex < noHeroes; ++heroIndex) {
                Hero hero = heroes.get(heroIndex);

                hero.getAffectedByOvertimeEffect();

                // the hero moves only if he is not stunned or dead
                if (hero.isDead()) {
                    continue;
                }

                if (hero.isStunned()) {
                    hero.setStunned(false);
                } else {
                    map.moveHero(hero, moves.get(round).charAt(heroIndex));
                }
            }

            // checking for fights
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

        // creating the output that will be written in the output file
        GameOutput gameOutput = new GameOutput(heroes);
        GameOutputWriter gameOutputWriter = new GameOutputWriter(args[0], args[1]);

        // writing the gameOutput in the file given as argument, closing it after
        gameOutputWriter.write(gameOutput);
        gameOutputWriter.close();
    }

    private static boolean samePosition(final Hero hero1, final Hero hero2) {
        return hero1.getPosMapX() == hero2.getPosMapX() && hero1.getPosMapY() == hero2.getPosMapY();
    }

    private static boolean bothAlive(final Hero hero1, final Hero hero2) {
        return !(hero1.isDead() || hero2.isDead());
    }

    // simulates a fight between 2 heroes
    private static void fight(final Hero hero1, final Hero hero2) {
        List<Ability> abilities1 = hero1.getAbilities();
        List<Ability> abilities2 = hero2.getAbilities();

        // updating abilities
        for (Ability ability : abilities1) {
            ability.updateAbility();
        }

        for (Ability ability : abilities2) {
            ability.updateAbility();
        }

        // hero1 casts all his abilities on hero2
        for (Ability ability : abilities1) {
            hero2.getAffectedByAbility(ability);
        }

        // hero2 casts all his abilities on hero1
        for (Ability ability : abilities2) {
            hero1.getAffectedByAbility(ability);
        }

        // if a hero dies in this fight the other one receives the xp bonus, and may level up
        if (hero1.isDead()) {
            hero2.bonusXpForKill(hero1);
            hero2.checkLevelUp();

            // The Great Magician should is notified about this death
            hero2.sendNotification(hero1);
        }

        if (hero2.isDead()) {
            hero1.bonusXpForKill(hero2);
            hero1.checkLevelUp();

            hero1.sendNotification(hero2);
        }
    }
}
