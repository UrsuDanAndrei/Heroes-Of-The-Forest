package input;

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
                        hero = heroesFactory.createHero(HeroTypes.PYROMANCER, posHeroX, posHeroY);
                        break;
                    case 'K':
                        hero = heroesFactory.createHero(HeroTypes.KNIGHT, posHeroX, posHeroY);
                        break;
                    case 'W':
                        hero = heroesFactory.createHero(HeroTypes.WIZARD, posHeroX, posHeroY);
                        break;
                    case 'R':
                        hero = heroesFactory.createHero(HeroTypes.ROGUE, posHeroX, posHeroY);
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

            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GameInput(noHeroes, noRounds, heroes, moves, map);
    }
}
