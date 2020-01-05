package main;

import abilities.Ability;

import angels.Angel;
import angels.AngelActions;
import common.Map;

import common.NotificationPanel;
import common.TheGreatMagician;
import heroes.Hero;

import heroes.HeroActions;
import input.GameInput;
import input.GameInputReader;

import output.GameOutput;
import output.GameOutputWriter;

import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() {

    }

    public static void main(final String[] args) {
        // reading data from the file given as argument and storing it in gameInput
        GameInputReader gameInputReader = new GameInputReader(args[0], args[1]);
        GameInput gameInput = gameInputReader.getGameInput();

        // gaining the data from gameInput
        int noRounds = gameInput.getNoRounds();
        int noHeroes = gameInput.getNoHeroes();

        Map map = gameInput.getMap();
        List<Hero> heroes = gameInput.getHeroes();
        List<String> moves = gameInput.getMoves();
        List<ArrayList<Angel>> allAngels = gameInput.getAllAngels();

        // The Great Magician can now be notified about important game changes
        addTheGreatMagicianAsObserver(heroes, allAngels);

        // simulating the fame flow
        for (int round = 0; round < noRounds; ++round) {
            NotificationPanel.getInstance().addNotification("~~ Round " + (round + 1) + " ~~");

            // each hero moves (if he can) as dictated by the array moves
            for (int heroIndex = 0; heroIndex < noHeroes; ++heroIndex) {
                Hero hero = heroes.get(heroIndex);

                hero.getAffectedByOvertimeEffect();

                // the hero moves only if he is not stunned or dead
                if (hero.isDead()) {
                    continue;
                }

                // if the hero is not dead or stunned he chooses a strategy
                if (hero.isStunned()) {
                    hero.setStunned(false);
                } else {
                    map.moveHero(hero, moves.get(round).charAt(heroIndex));

                    hero.chooseStrategy();
                    hero.applyStrategy();
                }
            }

            // checking for fights between heroes
            for (int i = 0; i < noHeroes; ++i) {
                for (int j = i + 1; j < noHeroes; ++j) {
                    Hero hero1 = heroes.get(i);
                    Hero hero2 = heroes.get(j);

                    if (samePosition(hero1, hero2) && bothAlive(hero1, hero2)) {
                        fight(hero1, hero2);
                    }
                }
            }

            // simulates angel-hero interaction
            ArrayList<Angel> angels = allAngels.get(round);
            for (Angel angel : angels) {
                angel.sendAngelNotification(AngelActions.SPAWN, null);

                for (Hero hero : heroes) {
                    if (samePosition(hero, angel)) {
                        hero.getAffectedByAngel(angel);
                    }
                }
            }

            NotificationPanel.getInstance().addNotification("NewLine");
        }

        // creating the output that will be written in the output file
        GameOutput gameOutput = new GameOutput(heroes,
                NotificationPanel.getInstance().getNotifications());
        GameOutputWriter gameOutputWriter = new GameOutputWriter(args[0], args[1]);

        // writing the gameOutput in the file given as argument, closing it after
        gameOutputWriter.write(gameOutput);
        gameOutputWriter.close();
    }

    private static boolean samePosition(final Hero hero, final Angel angel) {
        return hero.getPosMapX() == angel.getPosMapX() && hero.getPosMapY() == angel.getPosMapY();
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
        if (hero2.isDead()) {
            // The Great Magician should be notified about this death
            hero1.sendHeroNotification(HeroActions.KILL, hero2);

            hero1.bonusXpForKill(hero2);
            hero1.checkLevelUp();
        }

        if (hero1.isDead()) {
            hero2.sendHeroNotification(HeroActions.KILL, hero1);

            hero2.bonusXpForKill(hero1);
            hero2.checkLevelUp();
        }
    }

    private static void addTheGreatMagicianAsObserver(final List<Hero> heroes,
                                                      final List<ArrayList<Angel>> allAngels) {
        TheGreatMagician tgm = TheGreatMagician.getInstance();

        for (Hero hero : heroes) {
            hero.addPropertyChangeListener(tgm);
        }

        for (ArrayList<Angel> angels : allAngels) {
            for (Angel angel : angels) {
                angel.addPropertyChangeListener(tgm);
            }
        }
    }
}
