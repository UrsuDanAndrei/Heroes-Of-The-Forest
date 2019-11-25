package input;

import fileio.FileSystem;

import common.Map;

import heroes.Hero;
import heroes.HeroTypes;
import heroes.HeroesFactory;

import java.util.ArrayList;
import java.util.List;

public class GameInputReader {
    private final String inputPath;
    private final String outputPath;

    private int noHeroes;
    private int noRounds;
    private List<String> moves;
    private List<Hero> heroes;
    private Map map;

    public GameInputReader(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public void read() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNoHeroes() {
        return noHeroes;
    }

    public int getNoRounds() {
        return noRounds;
    }

    public List<String> getMoves() {
        return moves;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public Map getMap() {
        return map;
    }
}
