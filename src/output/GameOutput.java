package output;

import heroes.Hero;

import java.util.List;

public final class GameOutput {
    private List<Hero> heroes;

    public GameOutput(final List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
