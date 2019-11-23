package heroes;

import java.util.List;

public class Hero {
    private int posMapX;
    private int posMapY;

    private List<Abilities> abilities;
    private Curse curse;

    public Hero(int posMapX, int posMapY) {
        this.posMapX = posMapX;
        this.posMapY = posMapY;
    }
}
