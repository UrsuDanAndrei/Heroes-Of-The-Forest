package input;

import angels.Angel;
import angels.AngelTypes;
import angels.AngelsFactory;
import fileio.FileSystem;

import common.Map;

import heroes.Hero;
import heroes.HeroTypes;
import heroes.HeroesFactory;

import java.util.ArrayList;
import java.util.List;

public final class GameInputReader {
    private final String inputPath;
    private final String outputPath;

    public GameInputReader(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public GameInput getGameInput() {
        int noHeroes = 0;
        int noRounds = 0;

        List<Hero> heroes = null;
        List<String> moves = null;
        List<ArrayList<Angel>> allAngels = null;

        Map map = null;

        try {
            FileSystem fs = new FileSystem(inputPath, outputPath);

            // setting up the map dimensions
            int dimMapX = fs.nextInt();
            int dimMapY = fs.nextInt();

            // allocating and setting up mapCharMatrix
            List<String> mapCharMatrix = new ArrayList<>(dimMapX);
            for (int i = 0; i < dimMapX; ++i) {
                mapCharMatrix.add(fs.nextWord());
            }

            // setting up map
            map = Map.getInstance(dimMapX, dimMapY, mapCharMatrix);

            // setting up heroes
            noHeroes = fs.nextInt();
            heroes = new ArrayList<>(noHeroes);

            for (int i = 0; i < noHeroes; ++i) {
                char heroChar = fs.nextWord().charAt(0);
                int posHeroX = fs.nextInt();
                int posHeroY = fs.nextInt();

                Hero hero;
                HeroesFactory heroesFactory = HeroesFactory.getInstance();

                switch (heroChar) {
                    case 'P':
                        hero = heroesFactory.createHero(HeroTypes.PYROMANCER,
                                posHeroX, posHeroY, i);
                        break;
                    case 'K':
                        hero = heroesFactory.createHero(HeroTypes.KNIGHT, posHeroX, posHeroY, i);
                        break;
                    case 'W':
                        hero = heroesFactory.createHero(HeroTypes.WIZARD, posHeroX, posHeroY, i);
                        break;
                    case 'R':
                        hero = heroesFactory.createHero(HeroTypes.ROGUE, posHeroX, posHeroY, i);
                        break;
                    default:
                        hero = null;
                        break;
                }

                heroes.add(hero);
            }

            // setting up moves
            noRounds = fs.nextInt();
            moves = new ArrayList<>(noRounds);

            for (int i = 0; i < noRounds; i++) {
                moves.add(fs.nextWord());
            }

            /* element with index i in allAngels represents a list of angels that will be spawned
            in the round i + 1 */
            allAngels = new ArrayList<>(noRounds);

            for (int i = 0; i < noRounds; ++i) {
                // reading and creating angels for the current round
                int noRoundAngels = fs.nextInt();
                ArrayList<Angel> angels = new ArrayList<>(noRoundAngels);

                for (int j = 0; j < noRoundAngels; ++j) {
                    // the data is given as a string
                    String angelDataString = fs.nextWord();
                    String[] angelData = angelDataString.split(",");

                    // creates an angel using factory pattern and adds it to the list
                    angels.add(AngelsFactory.getInstance().createAngel(
                            AngelTypes.valueOf(angelData[0]),
                            Integer.valueOf(angelData[1]), Integer.valueOf(angelData[2])));
                }

                // adds the current list to the all angels list
                allAngels.add(angels);
            }

            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GameInput(noHeroes, noRounds, heroes, allAngels, moves, map);
    }
}
