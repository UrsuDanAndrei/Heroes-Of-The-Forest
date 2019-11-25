package output;

import heroes.Hero;

import java.util.List;

public class GameOutput {
    private List<Hero> heroes;

    public GameOutput(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
