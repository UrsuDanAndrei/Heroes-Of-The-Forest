package input;

import angels.Angel;
import common.Map;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public final class GameInput {
    private int noHeroes;
    private int noRounds;

    private List<Hero> heroes;
    private List<ArrayList<Angel>> allAngels;
    private List<String> moves;

    private Map map;

    public GameInput(final int noHeroes, final int noRounds, final List<Hero> heroes,
                     final List<ArrayList<Angel>> allAngels, final List<String> moves,
                     final Map map) {
        this.noHeroes = noHeroes;
        this.noRounds = noRounds;
        this.heroes = heroes;
        this.allAngels = allAngels;
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

    public List<ArrayList<Angel>> getAllAngels() {
        return allAngels;
    }

    public List<String> getMoves() {
        return moves;
    }

    public Map getMap() {
        return map;
    }
}
