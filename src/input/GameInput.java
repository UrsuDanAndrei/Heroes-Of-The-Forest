package input;

import common.Map;
import heroes.Hero;

import java.util.List;

public class GameInput {
    private int noHeroes;
    private int noRounds;

    private List<Hero> heroes;
    private List<String> moves;

    private Map map;

    public GameInput(int noHeroes, int noRounds, List<Hero> heroes, List<String> moves, Map map) {
        this.noHeroes = noHeroes;
        this.noRounds = noRounds;
        this.heroes = heroes;
        this.moves = moves;
        this.map = map;
    }

    public int getNoHeroes() {
        return noHeroes;
    }

    public int getNoRounds() {
        return noRounds;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<String> getMoves() {
        return moves;
    }

    public Map getMap() {
        return map;
    }
}
