package output;

import heroes.Hero;

import java.util.List;

public final class GameOutput {
    private List<Hero> heroes;
    private List<String> notifications;

    public GameOutput(final List<Hero> heroes, final List<String> notifications) {
        this.heroes = heroes;
        this.notifications = notifications;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
